<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Quiz System</title>
</head>
<body>
    <h2>Login to Start Quiz</h2>

    <% 
        String error = (String) request.getAttribute("error");
        if (error != null) { 
    %>
        <p style="color:red;"><%= error %></p>
    <% 
        } 
    %>

    <!-- Simple form, servlet mapping = /login -->
    <form action="login" method="post">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <button type="submit">Login</button>
    </form>

</body>
</html>
