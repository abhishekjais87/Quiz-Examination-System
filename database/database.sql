-- DB create + use
CREATE DATABASE IF NOT EXISTS quizdb;
USE quizdb;

-- USERS table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    fullname VARCHAR(200) NOT NULL
);

-- QUESTIONS table
CREATE TABLE IF NOT EXISTS questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    text TEXT NOT NULL,
    optA VARCHAR(255),
    optB VARCHAR(255),
    optC VARCHAR(255),
    optD VARCHAR(255),
    correct CHAR(1) NOT NULL
);

-- ATTEMPTS table
CREATE TABLE IF NOT EXISTS attempts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    score INT NOT NULL,
    attempt_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Default login user
INSERT INTO users(username, password, fullname)
VALUES ('student', '12345', 'Demo Student')
ON DUPLICATE KEY UPDATE fullname='Demo Student';

-- sample questions (5)
INSERT INTO questions(text, optA, optB, optC, optD, correct) VALUES
('Which of these is not an OOP concept?',
 'Encapsulation','Abstraction','Polymorphism','Compilation','D'),
('What does JVM stand for?',
 'Java Virtual Machine','Java Visual Machine','Just Virtual Machine','None of these','A'),
('Which keyword is used to inherit a class in Java?',
 'implements','extends','inherits','super','B'),
('Which operator is used to create objects?',
 'this','new','malloc','create','B'),
('Which is not a Java feature?',
 'Secure','Portable','Platform Dependent','Robust','C');
 
 
SELECT * FROM users;
SELECT COUNT(*) FROM questions;

