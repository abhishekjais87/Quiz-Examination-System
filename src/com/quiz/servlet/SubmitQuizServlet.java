package com.quiz.servlet;

import com.quiz.model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/submitQuiz")
public class SubmitQuizServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        @SuppressWarnings("unchecked")
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        if (questions == null) {
            resp.sendRedirect("startQuiz.jsp");
            return;
        }

        int score = 0;
        for (Question q : questions) {
            String ans = req.getParameter("q" + q.getId());
            if (ans != null && ans.equalsIgnoreCase(q.getCorrect())) {
                score++;
            }
        }

        session.setAttribute("lastScore", score);
        resp.sendRedirect("result.jsp");
    }
}
