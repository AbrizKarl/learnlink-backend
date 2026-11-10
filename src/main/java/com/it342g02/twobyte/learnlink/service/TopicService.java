package com.it342g02.twobyte.learnlink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.it342g02.twobyte.learnlink.entity.TopicEntity;
import com.it342g02.twobyte.learnlink.repository.TopicRepository;

@Service
public class TopicService {

    @Autowired
    TopicRepository trepo;

    // C - Create: returns the topic that was added
    public TopicEntity postTopic(TopicEntity topic) {
        return trepo.save(topic);
    }

    // R - Read
    public List<TopicEntity> getAllTopics() {
        return trepo.findAll();
    }

    // U - Update
    public TopicEntity putTopic(int id, TopicEntity newDetails) {
        // findById is a pre-defined method of the repository; send a 404 if the id is missing
        TopicEntity topic = trepo.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic " + id + " does not exist!"));
        topic.setSubjectId(newDetails.getSubjectId());
        topic.setTitle(newDetails.getTitle());
        topic.setLessonContent(newDetails.getLessonContent());
        return trepo.save(topic);
    }

    // D - Delete
    public String deleteTopic(int id) {
        if (!trepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic " + id + " does not exist!");
        }
        trepo.deleteById(id);
        return "Topic " + id + " is successfully deleted!";
    }
}
