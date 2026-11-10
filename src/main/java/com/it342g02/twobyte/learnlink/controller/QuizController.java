
package com.it342g02.twobyte.learnlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it342g02.twobyte.learnlink.entity.QuizEntity;
import com.it342g02.twobyte.learnlink.service.QuizService;

@RestController
@RequestMapping("/quiz/api")
@CrossOrigin(origins = { "http://localhost:5173", "http://localhost:3000" })
public class QuizController {

    @Autowired
    QuizService qserv;

    @GetMapping("/printAuthor")
    public String printAuthor() {
        return "Amoguis, Philma Jenica B.";
    }

    @PostMapping("/postNewQuiz")
    public QuizEntity postQuiz(@RequestBody QuizEntity quiz) {
        return qserv.postQuiz(quiz);
    }

    @GetMapping("/getAllQuizzes")
    public List<QuizEntity> getAllQuizzes() {
        return qserv.getAllQuizzes();
    }

    @PutMapping("/putQuiz")
    public QuizEntity putQuiz(@RequestParam int id, @RequestBody QuizEntity newDetails) {
        return qserv.putQuiz(id, newDetails);
    }

    @DeleteMapping("/deleteQuiz/{id}")
    public String deleteQuiz(@PathVariable int id) {
        return qserv.deleteQuiz(id);
    }
}
