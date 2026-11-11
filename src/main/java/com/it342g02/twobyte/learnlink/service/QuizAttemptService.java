
package com.it342g02.twobyte.learnlink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.it342g02.twobyte.learnlink.entity.QuizAttemptEntity;
import com.it342g02.twobyte.learnlink.repository.QuizAttemptRepository;

@Service
public class QuizAttemptService {

    @Autowired
    private QuizAttemptRepository quizAttemptRepository;

    public QuizAttemptEntity postQuizAttempt(QuizAttemptEntity attempt) {
        return quizAttemptRepository.save(attempt);
    }

    public List<QuizAttemptEntity> getAllQuizAttempts() {
        return quizAttemptRepository.findAll();
    }

    public QuizAttemptEntity putQuizAttempt(int id, QuizAttemptEntity newAttempt) {
        QuizAttemptEntity attempt = quizAttemptRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Quiz attempt not found"));

        attempt.setStudentId(newAttempt.getStudentId());
        attempt.setQuizId(newAttempt.getQuizId());
        attempt.setScore(newAttempt.getScore());
        attempt.setDateTaken(newAttempt.getDateTaken());

        return quizAttemptRepository.save(attempt);
    }

    public String deleteQuizAttempt(int id) {
        if (!quizAttemptRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Quiz attempt not found");
        }

        quizAttemptRepository.deleteById(id);
        return "Quiz attempt successfully deleted!";
    }
}
