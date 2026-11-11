package com.it342g02.twobyte.learnlink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.it342g02.twobyte.learnlink.entity.QuestionEntity;
import com.it342g02.twobyte.learnlink.repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionEntity postQuestion(QuestionEntity question) {
        return questionRepository.save(question);
    }

    public List<QuestionEntity> getAllQuestions() {
        return questionRepository.findAll();
    }

    public QuestionEntity putQuestion(int id, QuestionEntity newQuestion) {
        QuestionEntity question = questionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Question not found"));

        question.setQuizId(newQuestion.getQuizId());
        question.setQuestionText(newQuestion.getQuestionText());
        question.setType(newQuestion.getType());
        question.setCorrectAnswer(newQuestion.getCorrectAnswer());

        return questionRepository.save(question);
    }

    public String deleteQuestion(int id) {
        if (!questionRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Question not found");
        }

        questionRepository.deleteById(id);
        return "Question successfully deleted!";
    }
}
