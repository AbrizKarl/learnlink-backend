
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

import com.it342g02.twobyte.learnlink.entity.QuestionEntity;
import com.it342g02.twobyte.learnlink.service.QuestionService;

@RestController
@RequestMapping("/question/api")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/postNewQuestion")
    public QuestionEntity postQuestion(@RequestBody QuestionEntity question) {
        return questionService.postQuestion(question);
    }

    @GetMapping("/getAllQuestions")
    public List<QuestionEntity> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PutMapping("/putQuestion")
    public QuestionEntity putQuestion(
            @RequestParam int id,
            @RequestBody QuestionEntity newQuestion) {
        return questionService.putQuestion(id, newQuestion);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable int id) {
        return questionService.deleteQuestion(id);
    }
}