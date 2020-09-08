DROP DATABASE IF EXISTS talmudic_studies;
CREATE DATABASE talmudic_studies;
USE talmudic_studies;

CREATE TABLE IF NOT EXISTS tractates(
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    pages INT(10) NOT NULL
);

INSERT INTO tractates(name, pages) VALUES("Brachos", 125);
INSERT INTO tractates(name, pages) VALUES("Shabbos", 314);


CREATE TABLE IF NOT EXISTS students(
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    personal_name VARCHAR(30) NOT NULL,
    family_name VARCHAR(30) NOT NULL
);

INSERT INTO students(personal_name, family_name) VALUES("Yehoshua", "Kahan");
INSERT INTO students(personal_name, family_name) VALUES("Ploni", "Almoni");

CREATE TABLE IF NOT EXISTS students_tractates(
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_id INT(10) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(id),
    tractate_id INT(10) NOT NULL,
    FOREIGN KEY (tractate_id) REFERENCES tractates(id),
    page INT(10) NOT NULL,
    date_studied TIMESTAMP NOT NULL DEFAULT current_timestamp
);

