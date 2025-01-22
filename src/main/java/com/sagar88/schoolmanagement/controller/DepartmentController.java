package com.sagar88.schoolmanagement.controller;

import com.sagar88.schoolmanagement.entity.Department;
import com.sagar88.schoolmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id){
        return  departmentService.getDepartment(id);
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody  Department department){
        try{
            return new ResponseEntity<>(departmentService.addDepartment(department),HttpStatus.CREATED);
        }catch (Exception e){
            return
        }
    }
}
