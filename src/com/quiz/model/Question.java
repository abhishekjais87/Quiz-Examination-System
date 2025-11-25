package com.quiz.model;

public class Question {
    private int id;
    private String text;
    private String optA;
    private String optB;
    private String optC;
    private String optD;
    private String correct;

    public Question(int id, String text, String optA, String optB, String optC, String optD, String correct) {
        this.id = id;
        this.text = text;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.optD = optD;
        this.correct = correct;
    }

    public int getId() { return id; }
    public String getText() { return text; }
    public String getOptA() { return optA; }
    public String getOptB() { return optB; }
    public String getOptC() { return optC; }
    public String getOptD() { return optD; }
    public String getCorrect() { return correct; }
}
