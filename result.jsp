<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
    Integer score = (Integer) session.getAttribute("lastScore");
    if (score == null) {
        response.sendRedirect("startQuiz.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
</head>
<body>
    <h2>Your Quiz Result</h2>
    <p><b>Your score:</b> <%= score %></p>

    <br>
    <a href="startQuiz.jsp">Go to Home</a>
    <br><br>
    <a href="logout">Logout</a>
</body>
</html>
