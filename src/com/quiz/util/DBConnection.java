package com.quiz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL  = "jdbc:mysql://localhost:3306/quizdb";
    private static final String USER = "root";   // 👈 apna MySQL user
    private static final String PASS = "HeartsAgive@2005";   // 👈 apna MySQL password

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // MySQL 8+ driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
