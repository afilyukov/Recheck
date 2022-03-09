CREATE TABLE students (
                          id        LONG AUTO_INCREMENT PRIMARY KEY,
                          name      VARCHAR(255),
                          age       INT
);

INSERT INTO students (name, age) VALUES
                                     ('STUDENT_01', 20),
                                     ('STUDENT_02', 18),
                                     ('STUDENT_03', 18),
                                     ('STUDENT_04', 33),
                                     ('STUDENT_05', 21),
                                     ('STUDENT_06', 18),
                                     ('STUDENT_07', 18),
                                     ('STUDENT_08', 22),
                                     ('STUDENT_09', 21),
                                     ('STUDENT_10', 17);