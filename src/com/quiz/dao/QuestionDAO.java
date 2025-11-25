package com.quiz.dao;

import com.quiz.model.Question;
import com.quiz.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class QuestionDAO {

    public java.util.List<Question> getRandomQuestions(int limit) {
        java.util.List<Question> list = new ArrayList<>();

        String sql = "SELECT id, text, optA, optB, optC, optD, correct " +
                     "FROM questions ORDER BY RAND() LIMIT ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, limit);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Question(
                            rs.getInt("id"),
                            rs.getString("text"),
                            rs.getString("optA"),
                            rs.getString("optB"),
                            rs.getString("optC"),
                            rs.getString("optD"),
                            rs.getString("correct")
                    ));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
