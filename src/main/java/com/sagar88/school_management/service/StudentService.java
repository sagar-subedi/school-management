package com.sagar88.school_management.service;

import com.sagar88.school_management.entity.Class;
import com.sagar88.school_management.entity.Result;
import com.sagar88.school_management.entity.Student;
import com.sagar88.school_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Class> getClassesForStudent(Long studentId) {
        return studentRepository.findClassesByStudentId(studentId);
    }

    public List<Result> getResultsForStudent(Long studentId) {
        return studentRepository.findResultsByStudentId(studentId);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
