
package com.it342g02.twobyte.learnlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it342g02.twobyte.learnlink.entity.QuizAttemptEntity;
import com.it342g02.twobyte.learnlink.service.QuizAttemptService;

@RestController
@RequestMapping("/quizAttempt/api")
public class QuizAttemptController {

    @Autowired
    private QuizAttemptService quizAttemptService;

    @PostMapping("/postNewQuizAttempt")
    public QuizAttemptEntity postQuizAttempt(@RequestBody QuizAttemptEntity attempt) {
        return quizAttemptService.postQuizAttempt(attempt);
    }

    @GetMapping("/getAllQuizAttempts")
    public List<QuizAttemptEntity> getAllQuizAttempts() {
        return quizAttemptService.getAllQuizAttempts();
    }

    @PutMapping("/putQuizAttempt")
    public QuizAttemptEntity putQuizAttempt(
            @RequestParam int id,
            @RequestBody QuizAttemptEntity newAttempt) {
        return quizAttemptService.putQuizAttempt(id, newAttempt);
    }

    @DeleteMapping("/deleteQuizAttempt/{id}")
    public String deleteQuizAttempt(@PathVariable int id) {
        return quizAttemptService.deleteQuizAttempt(id);
    }
}
