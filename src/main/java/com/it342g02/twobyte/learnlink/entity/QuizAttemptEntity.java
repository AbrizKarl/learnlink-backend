
package com.it342g02.twobyte.learnlink.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz_attempt")
public class QuizAttemptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attemptId;

    private int studentId;
    private int quizId;
    private int score;
    private LocalDate dateTaken;

    public QuizAttemptEntity() {
    }

    public QuizAttemptEntity(int studentId, int quizId, int score, LocalDate dateTaken) {
        this.studentId = studentId;
        this.quizId = quizId;
        this.score = score;
        this.dateTaken = dateTaken;
    }

    public int getAttemptId() {
        return attemptId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getQuizId() {
        return quizId;
    }

    public int getScore() {
        return score;
    }

    public LocalDate getDateTaken() {
        return dateTaken;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDateTaken(LocalDate dateTaken) {
        this.dateTaken = dateTaken;
    }
}
