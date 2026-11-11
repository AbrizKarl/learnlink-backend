package com.it342g02.twobyte.learnlink.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "question")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;

    private int quizId;
    private String questionText;
    private String type;
    private String correctAnswer;

    public QuestionEntity() {
    }

    public QuestionEntity(int quizId, String questionText, String type, String correctAnswer) {
        this.quizId = quizId;
        this.questionText = questionText;
        this.type = type;
        this.correctAnswer = correctAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getQuizId() {
        return quizId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getType() {
        return type;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
