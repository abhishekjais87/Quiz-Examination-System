package com.quiz.dao;

import com.quiz.model.User;
import com.quiz.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public User authenticate(String username, String password) {
        String sql = "SELECT id, username, password, fullname " +
                     "FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("fullname")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;  // invalid login
    }
}
