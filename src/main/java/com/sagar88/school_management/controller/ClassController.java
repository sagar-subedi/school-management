package com.sagar88.school_management.controller;

import com.sagar88.school_management.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.sagar88.school_management.entity.Class;
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

//    @GetMapping
//    public ResponseEntity<List<Class>> getAllClasses() {
//        List<Class> classes = classService.g();
//        return new ResponseEntity<>(classes, HttpStatus.OK);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Class> getClassById(@PathVariable Long id) {
//        Class Class = classService.ge(id);
//        return new ResponseEntity<>(Class, HttpStatus.OK);
//    }

    @GetMapping("/standard/{standard}")
    public ResponseEntity<List<Class>> getClassesByStandard(@PathVariable String standard) {
        List<Class> classes = classService.getClassesByStandard(standard);
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }
}

