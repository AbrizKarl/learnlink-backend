
package com.it342g02.twobyte.learnlink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.it342g02.twobyte.learnlink.entity.SubjectEntity;
import com.it342g02.twobyte.learnlink.repository.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectEntity postSubject(SubjectEntity subject) {
        return subjectRepository.save(subject);
    }

    public List<SubjectEntity> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public SubjectEntity putSubject(int id, SubjectEntity newSubject) {
        SubjectEntity subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Subject not found"));

        subject.setTeacherId(newSubject.getTeacherId());
        subject.setName(newSubject.getName());
        subject.setGradeLevel(newSubject.getGradeLevel());

        return subjectRepository.save(subject);
    }

    public String deleteSubject(int id) {
        if (!subjectRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Subject not found");
        }

        subjectRepository.deleteById(id);
        return "Subject successfully deleted!";
    }
}
