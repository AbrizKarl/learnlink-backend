
package com.it342g02.twobyte.learnlink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.it342g02.twobyte.learnlink.entity.QuizEntity;
import com.it342g02.twobyte.learnlink.repository.QuizRepository;

@Service
public class QuizService {

    @Autowired
    QuizRepository qrepo;

    public QuizEntity postQuiz(QuizEntity quiz) {
        return qrepo.save(quiz);
    }

    public List<QuizEntity> getAllQuizzes() {
        return qrepo.findAll();
    }

    public QuizEntity putQuiz(int id, QuizEntity newDetails) {
        QuizEntity quiz = qrepo.findById(id).orElseThrow(
            () -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Quiz " + id + " does not exist!"
            )
        );

        quiz.setTopicId(newDetails.getTopicId());
        quiz.setTitle(newDetails.getTitle());
        quiz.setPassingScore(newDetails.getPassingScore());

        return qrepo.save(quiz);
    }

    public String deleteQuiz(int id) {
        if (!qrepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Quiz " + id + " does not exist!"
            );
        }

        qrepo.deleteById(id);
        return "Quiz " + id + " is successfully deleted!";
    }
}
