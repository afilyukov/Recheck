USE geekbrains;

BEGIN;

DROP TABLE IF EXISTS Tickets CASCADE;
DROP TABLE IF EXISTS Film_Session CASCADE;
DROP TABLE IF EXISTS Film CASCADE;

CREATE TABLE Film(
                     id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                     film_name VARCHAR(25) NOT NULL,
                     duration INT(10) NOT NULL);

CREATE UNIQUE INDEX UI_FILM_NAME ON Film (film_name);

CREATE TABLE Film_Session(
                             id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                             film_id INT(10) NOT NULL,
                             start_time DATETIME NOT NULL,
                             price DECIMAL NOT NULL,
                             FOREIGN KEY (film_id) REFERENCES Film (id));

CREATE INDEX I_FILM_SESSION ON Film_Session (film_id);

CREATE TABLE Tickets (
                         id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         session_id INT(10) NOT NULL,
                         place INT(3) NOT NULL,
                         FOREIGN KEY (session_id) REFERENCES Film_Session(id));

INSERT INTO Film (`film_name`, `duration`)
VALUES	('матрица', 90),
          ('конек-горбунок', 30),
          ('Броненосец потемкин', 120),
          ('Аватар', 120),
          ('Snatch', 90);

INSERT INTO Film_Session (`film_id`, `start_time`, `price`)
SELECT id, '2021-07-01 07:00:00', 250
FROM Film
WHERE film_name = 'матрица'
UNION
SELECT id, '2021-07-01 07:30:00', 350
FROM Film
WHERE film_name = 'конек-горбунок'
UNION
SELECT id, '2021-07-01 11:30:00', 350
FROM Film
WHERE film_name = 'Броненосец потемкин'
UNION
SELECT id, '2021-07-01 15:00:00', 350
FROM Film
WHERE film_name = 'Аватар'
UNION
SELECT id, '2021-07-01 18:00:00', 450
FROM Film
WHERE film_name = 'Snatch'
UNION
SELECT id, '2021-07-01 20:00:00', 350
FROM Film
WHERE film_name = 'Аватар'
UNION
SELECT id, '2021-07-01 22:00:00', 350
FROM Film
WHERE film_name = 'матрица'
UNION

SELECT id, '2021-07-02 07:00:00', 250
FROM Film
WHERE film_name = 'конек-горбунок'
UNION
SELECT id, '2021-07-02 09:00:00', 350
FROM Film
WHERE film_name = 'матрица'
UNION
SELECT id, '2021-07-02 11:30:00', 350
FROM Film
WHERE film_name = 'Броненосец потемкин'
UNION
SELECT id, '2021-07-02 15:00:00', 350
FROM Film
WHERE film_name = 'Аватар'
UNION
SELECT id, '2021-07-02 18:00:00', 450
FROM Film
WHERE film_name = 'Snatch'
UNION
SELECT id, '2021-07-02 20:00:00', 350
FROM Film
WHERE film_name = 'Snatch'
UNION
SELECT id, '2021-07-02 22:00:00', 350
FROM Film
WHERE film_name = 'матрица';

INSERT INTO Tickets (`session_id`,`place`)
SELECT id, 1
FROM Film_Session
WHERE id = 3
UNION
SELECT id, 1
FROM Film_Session
UNION
SELECT id, 2
FROM Film_Session
UNION
SELECT id, 3
FROM Film_Session
UNION
SELECT id, 4
FROM Film_Session
UNION
SELECT id, 5
FROM Film_Session
WHERE id = 1
UNION
SELECT id, 25
FROM Film_Session
WHERE id = 2
UNION
SELECT id, 2
FROM Film_Session
WHERE id = 3
UNION
SELECT id, 10
FROM Film_Session
WHERE id = 3;

COMMIT;