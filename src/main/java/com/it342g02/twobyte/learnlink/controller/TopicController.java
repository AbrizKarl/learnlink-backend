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

import com.it342g02.twobyte.learnlink.entity.TopicEntity;
import com.it342g02.twobyte.learnlink.service.TopicService;

@RestController
@RequestMapping("/topic/api")
// CrossOrigin is needed when the React frontend (Vite = 5173) calls this backend
@CrossOrigin(origins = { "http://localhost:5173", "http://localhost:3000" })
public class TopicController {

    @Autowired
    TopicService tserv;

    @GetMapping("/printAuthor")
    public String printAuthor() {
        return "Karl Andrei B. Abriz";
    }

    // C - Create
    @PostMapping("/postNewTopic")
    public TopicEntity postTopic(@RequestBody TopicEntity topic) {
        return tserv.postTopic(topic);
    }

    // R - Read
    @GetMapping("/getAllTopics")
    public List<TopicEntity> getAllTopics() {
        return tserv.getAllTopics();
    }

    // U - Update
    @PutMapping("/putTopic")
    public TopicEntity putTopic(@RequestParam int id, @RequestBody TopicEntity newDetails) {
        return tserv.putTopic(id, newDetails);
    }

    // D - Delete
    @DeleteMapping("/deleteTopic/{id}")
    public String deleteTopic(@PathVariable int id) {
        return tserv.deleteTopic(id);
    }
}
