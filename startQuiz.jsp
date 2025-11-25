<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.quiz.model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Start Quiz</title>
</head>
<body>
    <h2>Welcome, <%= user.getFullname() %></h2>
    <p>You can now start your quiz.</p>

    <form action="startQuiz" method="get">
        <button type="submit">Start Quiz</button>
    </form>

    <br>
    <a href="logout">Logout</a>
</body>
</html>
