#ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
# Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;
USE geekbrains;
SELECT f1.film_name AS 'Film 1 Name',
       s1.start_time AS 'Start at',
       f1.duration AS 'Duration',
       f2.film_name AS 'Film 2 Name',
       s2.start_time AS 'Start at',
       f2.duration AS 'Duration'
FROM Film f1
         JOIN Film_Session s1 ON f1.id = s1.film_id
         JOIN Film_Session s2 ON s2.start_time >= s1.start_time AND date_add(s1.start_time, INTERVAL f1.duration minute) > s2.start_time
         JOIN Film f2 ON s2.film_id = f2.id
WHERE f1.id <> f2.id ORDER BY s1.start_time;

#перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва. Колонки «фильм 1»,
# «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;
USE geekbrains;
SELECT * FROM
    (SELECT f1.film_name AS 'Film 1 Name',
            fs1.start_time AS 'Start at',
            f1.duration AS 'Duration 1',
            TIMESTAMPDIFF(MINUTE, date_add(fs1.start_time, INTERVAL f1.duration MINUTE),
                          fs2.start_time) AS 'Gap', f2.film_name AS 'Film 2 Name', fs2.start_time AS 'Start 2 at',
            f2.duration AS 'Duration 2'
     FROM Film f1
              JOIN Film_Session fs1 ON f1.id = fs1.film_id
              JOIN Film_Session fs2 ON fs2.id = (SELECT id
                                                 FROM Film_Session fs
                                                 WHERE fs1.start_time < fs.start_time
                                                 ORDER BY fs.start_time LIMIT 1)
         AND TIMESTAMPDIFF(MINUTE, date_add(fs1.start_time, INTERVAL f1.duration MINUTE), fs2.start_time) >= 30
              INNER JOIN Film f2 ON fs2.film_id = f2.id
     WHERE f1.id <> f2.id)
        sel ORDER BY sel.gap DESC;

#список фильмов, для каждого — с указанием общего числа посетителей за все время, среднего числа зрителей за сеанс и
#общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли). Внизу таблицы должна быть строчка «итого»,
# содержащая данные по всем фильмам сразу;
USE geekbrains;
    WITH r AS (SELECT f.film_name as film,
		CAST(COUNT(t.id) AS DECIMAL) AS tickets_count,
        CAST(COUNT(t.ID) AS DOUBLE) / CAST(COUNT(distinct fs.ID) AS DOUBLE) AS AVG_ticket_session,
        CAST(SUM(fs.price) AS DECIMAL) AS Total_Price
        FROM Film f
			JOIN Film_Session fs ON f.ID = fs.film_id
			JOIN Tickets t ON fs.id = t.session_id
		GROUP BY f.film_name
        ORDER BY SUM(fs.price) DESC)
SELECT *
FROM r
UNION ALL
SELECT 'Всего', SUM(r.tickets_count), AVG(r.AVG_ticket_session), SUM(r.Total_Price)
FROM r;

#число посетителей и кассовые сборы, сгруппированные по времени начала фильма:
#с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).
USE geekbrains;
SELECT '9.00-15:00' AS 'Interval',
       COUNT(T.id) AS 'Customers Count',
       SUM(FS.PRICE) AS 'Sum Price'
FROM Film_Session FS
JOIN Tickets T on FS.id = T.session_id
WHERE HOUR(FS.start_time)>=9 AND HOUR(FS.start_time)< 15
UNION ALL
SELECT '15.00-18:00',
       COUNT(T.id),
       SUM(FS.PRICE)
FROM Film_Session FS
         JOIN Tickets T on FS.id = T.session_id
WHERE HOUR(FS.start_time)>=15 AND HOUR(FS.start_time)<18
UNION ALL
SELECT '18.00-21:00',
       COUNT(T.id),
       SUM(FS.PRICE)
FROM Film_Session FS
         JOIN Tickets T on FS.id = T.session_id
WHERE HOUR(FS.start_time)>=18 AND HOUR(FS.start_time)<21
UNION ALL
SELECT '21.00-00:00',
       COUNT(T.id),
       SUM(FS.PRICE)
FROM Film_Session FS
         JOIN Tickets T on FS.id = T.session_id
WHERE HOUR(FS.start_time)>=21;