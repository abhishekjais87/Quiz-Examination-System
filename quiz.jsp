<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="java.util.*,com.quiz.model.Question" %>
<%
    List<Question> questions = (List<Question>) session.getAttribute("questions");
    if (questions == null) {
        response.sendRedirect("startQuiz.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
    <script>
        var seconds = 120; // 2 minutes timer
        setInterval(function() {
            if (seconds <= 0) {
                document.getElementById("quizForm").submit();
            }
            document.getElementById("timer").innerHTML = seconds + " seconds left";
            seconds--;
        }, 1000);
    </script>
</head>
<body>
    <h2>Quiz Section</h2>
    <div id="timer" style="color: red; font-size: 18px;"></div>
    <br>

    <form id="quizForm" method="post" action="submitQuiz">
        <% for (Question q : questions) { %>
            <p><b><%= q.getText() %></b></p>
            <input type="radio" name="q<%= q.getId() %>" value="A"> A) <%= q.getOptA() %> <br>
            <input type="radio" name="q<%= q.getId() %>" value="B"> B) <%= q.getOptB() %> <br>
            <input type="radio" name="q<%= q.getId() %>" value="C"> C) <%= q.getOptC() %> <br>
            <input type="radio" name="q<%= q.getId() %>" value="D"> D) <%= q.getOptD() %> <br>
            <hr>
        <% } %>

        <button type="submit">Submit Quiz</button>
    </form>
</body>
</html>
