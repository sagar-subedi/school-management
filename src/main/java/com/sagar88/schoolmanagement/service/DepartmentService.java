package com.sagar88.schoolmanagement.service;

import com.sagar88.schoolmanagement.dto.DepartmentDTO;
import com.sagar88.schoolmanagement.entity.Department;
import com.sagar88.schoolmanagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) throws Exception{
        if(departmentRepository.findByName(department.getName()).isPresent()){
            throw new Exception("Department already exist");
        }
        return  departmentRepository.save(department);
    }

    public Department getDepartment(Long id){
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isPresent()){
            return department.get();
        }
        return null;
    }
}
