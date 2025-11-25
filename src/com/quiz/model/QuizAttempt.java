package com.quiz.model;

import java.time.LocalDateTime;

public class QuizAttempt {
    private int id;
    private String username;
    private int correct;
    private int total;
    private LocalDateTime dateTime;

    public QuizAttempt(int id, String username, int correct, int total, LocalDateTime dateTime) {
        this.id = id;
        this.username = username;
        this.correct = correct;
        this.total = total;
        this.dateTime = dateTime;
    }

    public QuizAttempt(String username, int correct, int total) {
        this.username = username;
        this.correct = correct;
        this.total = total;
        this.dateTime = LocalDateTime.now();
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public int getCorrect() { return correct; }
    public int getTotal() { return total; }
    public LocalDateTime getDateTime() { return dateTime; }
}
