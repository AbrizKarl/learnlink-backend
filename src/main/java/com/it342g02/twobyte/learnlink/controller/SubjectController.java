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

import com.it342g02.twobyte.learnlink.entity.SubjectEntity;
import com.it342g02.twobyte.learnlink.service.SubjectService;

@RestController
@RequestMapping("/subject/api")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/postNewSubject")
    public SubjectEntity postSubject(@RequestBody SubjectEntity subject) {
        return subjectService.postSubject(subject);
    }

    @GetMapping("/getAllSubjects")
    public List<SubjectEntity> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @PutMapping("/putSubject")
    public SubjectEntity putSubject(
            @RequestParam int id,
            @RequestBody SubjectEntity newSubject) {
        return subjectService.putSubject(id, newSubject);
    }

    @DeleteMapping("/deleteSubject/{id}")
    public String deleteSubject(@PathVariable int id) {
        return subjectService.deleteSubject(id);
    }
}
