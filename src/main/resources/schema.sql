DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS exam;

CREATE TABLE student (
                         student_no VARCHAR(6) PRIMARY KEY,
                         name VARCHAR(10),
                         phone VARCHAR(15),
                         gender CHAR(1),
                         address VARCHAR(20)
);

CREATE TABLE exam (
                      exam_no VARCHAR(6) PRIMARY KEY,
                      kor INT,
                      math INT,
                      eng INT,
                      hist INT
);
