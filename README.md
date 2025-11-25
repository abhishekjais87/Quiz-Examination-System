# 📘 Quiz Examination System — Java Web Application

A web-based quiz assessment system built using **Java Servlet, JSP, JDBC & MySQL**.  
The system enables students to log in, attempt quizzes, submit answers, and view results instantly.  
All quiz attempts and scores are stored securely in a database.

---

## 🚀 Features
- User login & authentication
- Random MCQ questions from database
- Auto evaluation & score calculation
- Result stored in database
- Session-based security (no quiz without login)
- Clean MVC architecture
- Deployed on Apache Tomcat

---

## 🏛 Project Architecture
| Layer | Technology |
|-------|------------|
| View | JSP (login.jsp, quiz.jsp, result.jsp) |
| Controller | Java Servlets |
| Model | Java Classes (User, Question, QuizAttempt) |
| DB Layer | DAO (UserDAO, QuestionDAO, AttemptDAO) |
| Database | MySQL via JDBC |
| Server | Apache Tomcat |

/Project Folder
├─ src/com/quiz/model
├─ src/com/quiz/dao
├─ src/com/quiz/servlet
├─ src/com/quiz/util
├─ Web Pages (JSP)
├─ WEB-INF/classes
├─ WEB-INF/lib (mysql-connector.jar)
└─ WEB-INF/web.xml



## 🗄 Database Setup (MySQL)
```sql
CREATE DATABASE quizdb;
USE quizdb;

CREATE TABLE users (
 id INT AUTO_INCREMENT PRIMARY KEY,
 username VARCHAR(100) UNIQUE,
 password VARCHAR(100),
 fullname VARCHAR(200)
);

CREATE TABLE questions (
 id INT AUTO_INCREMENT PRIMARY KEY,
 text TEXT,
 optA VARCHAR(255),
 optB VARCHAR(255),
 optC VARCHAR(255),
 optD VARCHAR(255),
 correct CHAR(1)
);

CREATE TABLE attempts (
 id INT AUTO_INCREMENT PRIMARY KEY,
 username VARCHAR(50),
 correct INT,
 total INT,
 date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users VALUES (1,'student','12345','Demo Student');
🛠 Requirements
Software	Version
JDK	8 / 11 / 17
Apache Tomcat	9
MySQL	5.7 / 8+
MySQL Connector/J	Latest

▶ How to Run the Project
Copy project folder to:

makefile
C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\
Add mysql-connector-j.jar to:

WEB-INF/lib
Compile Java files:

nginx
javac -cp "C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\servlet-api.jar;." -d "../WEB-INF/classes" com\quiz\model\*.java com\quiz\dao\*.java com\quiz\servlet\*.java com\quiz\util\*.java
Start Tomcat:
startup.bat

Open Browser:
http://localhost:8081/QuizExaminationSystem/login.jsp
🔐 Default Login
Username	Password
student	12345

🌱 Future Enhancements

Admin panel to add quiz questions
Timer auto-submit
Leaderboard
Email result export
Mobile responsive UI
