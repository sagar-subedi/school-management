package com.sagar88.school_management.controller;

import com.sagar88.school_management.entity.Exam;
import com.sagar88.school_management.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping
    public ResponseEntity<Exam> addExam(@RequestBody Exam exam) {
        Exam createdExam = examService.createExam(exam);
        return new ResponseEntity<>(createdExam, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<Exam>> getAllExams() {
//        List<Exam> exams = examService.ge();
//        return new ResponseEntity<>(exams, HttpStatus.OK);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
//        Exam exam = examService.ge(id);
//        return new ResponseEntity<>(exam, HttpStatus.OK);
//    }
}

