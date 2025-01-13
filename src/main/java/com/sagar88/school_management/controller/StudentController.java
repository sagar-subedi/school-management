package com.sagar88.school_management.controller;

import com.sagar88.school_management.dto.ClassDTO;
import com.sagar88.school_management.dto.ResultDTO;
import com.sagar88.school_management.entity.Result;

import com.sagar88.school_management.service.StudentService;
import com.sagar88.school_management.entity.Class;
import com.sagar88.school_management.utils.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{studentId}/classes")
    public ResponseEntity<List<ClassDTO>> getStudentClasses(@PathVariable Long studentId) {
        List<Class> classes = studentService.getClassesForStudent(studentId);
        return new ResponseEntity<>(classes.stream().map(DTOMapper::toClassDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{studentId}/results")
    public ResponseEntity<List<ResultDTO>> getStudentResults(@PathVariable Long studentId) {
        List<Result> results = studentService.getResultsForStudent(studentId);
        return new ResponseEntity<>(results.stream().map(DTOMapper::toResultDTO).collect(Collectors.toList()), HttpStatus.OK);
    }
}

