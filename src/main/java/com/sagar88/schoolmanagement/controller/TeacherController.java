package com.sagar88.schoolmanagement.controller;

import com.sagar88.schoolmanagement.dto.ClassDTO;
import com.sagar88.schoolmanagement.entity.Result;
import com.sagar88.schoolmanagement.service.TeacherService;
import com.sagar88.schoolmanagement.utils.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.sagar88.schoolmanagement.entity.Class;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{teacherId}/classes")
    public ResponseEntity<List<ClassDTO>> getTeacherClasses(@PathVariable Long teacherId) {
        List<Class> classes = teacherService.getClassesForTeacher(teacherId);
        return new ResponseEntity<>(classes.stream().map(DTOMapper::toClassDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("/{teacherId}/exams/{examId}/results")
    public ResponseEntity<Result> addResult(
            @PathVariable Long teacherId,
            @PathVariable Long examId,
            @RequestBody Result result) {
//        Result createdResult = teacherService.(teacherId, examId, result);
        Result createdResult = new Result();
        return new ResponseEntity<>(createdResult, HttpStatus.CREATED);

    }
}

