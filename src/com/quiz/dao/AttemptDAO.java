package com.quiz.dao;

import com.quiz.model.QuizAttempt;
import com.quiz.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AttemptDAO {

    public void saveAttempt(QuizAttempt attempt) {
        String sql = "INSERT INTO attempts(username, correct, total, date_time) VALUES (?, ?, ?, NOW())";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, attempt.getUsername());
            ps.setInt(2, attempt.getCorrect());
            ps.setInt(3, attempt.getTotal());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
