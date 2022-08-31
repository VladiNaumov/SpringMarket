DROP TABLE IF EXISTS demo CASCADE;
CREATE TABLE demo
(
       Id SERIAL PRIMARY KEY,
       Name CHARACTER VARYING(255),
       Age INTEGER

);

DROP TABLE IF EXISTS universities CASCADE;
CREATE TABLE universities (id bigserial PRIMARY KEY, title VARCHAR(255));
INSERT INTO universities (title) VALUES
('DSTU'),
('NPU');

DROP TABLE IF EXISTS students CASCADE;
CREATE TABLE students (id bigserial PRIMARY KEY, name VARCHAR(255), university_id bigint REFERENCES universities (id));
INSERT INTO students (name, university_id) VALUES
('Alexander', 1),
('Bob', 2),
('John', 1);


DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (id bigserial PRIMARY KEY, name VARCHAR(255), price decimal, discount integer);

INSERT INTO product (name, price, discount)
VALUES
('LEIPOA', 2.80, 90),
('MAITOA', 1.20, 60),
('APPELSINI', 3.60, 100);
