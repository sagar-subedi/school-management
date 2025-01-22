package com.sagar88.schoolmanagement.controller;

import com.sagar88.schoolmanagement.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.sagar88.schoolmanagement.entity.Class;
import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    public ResponseEntity<Class> addClass(@RequestBody Class Class) {
        Class createdClass = classService.createClass(Class);
        return new ResponseEntity<>(createdClass, HttpStatus.CREATED);
    }

    @GetMapping("/standard/{standard}")
    public ResponseEntity<List<Class>> getClassesByStandard(@PathVariable String standard) {
        List<Class> classes = classService.getClassesByStandard(standard);
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }
}

