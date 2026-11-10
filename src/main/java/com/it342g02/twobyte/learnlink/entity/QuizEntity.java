
package com.it342g02.twobyte.learnlink.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz")
public class QuizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quizId;

    private int topicId;
    private String title;
    private int passingScore;

    public QuizEntity() {
    }

    public QuizEntity(int topicId, String title, int passingScore) {
        this.topicId = topicId;
        this.title = title;
        this.passingScore = passingScore;
    }

    public int getQuizId() {
        return quizId;
    }

    public int getTopicId() {
        return topicId;
    }

    public String getTitle() {
        return title;
    }

    public int getPassingScore() {
        return passingScore;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPassingScore(int passingScore) {
        this.passingScore = passingScore;
    }
}
