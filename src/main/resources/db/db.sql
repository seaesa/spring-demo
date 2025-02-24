CREATE DATABASE IF NOT EXISTS spring_demo;
USE spring_demo;
CREATE TABLE IF NOT EXISTS student (
  id int primary key auto_increment,
  name varchar(50),
  score double
);
INSERT INTO student (name, score)
values ("Đặng Ngọc Hải", 50);