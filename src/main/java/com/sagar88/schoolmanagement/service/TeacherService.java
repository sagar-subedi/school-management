package com.sagar88.schoolmanagement.service;

import com.sagar88.schoolmanagement.entity.Class;
import com.sagar88.schoolmanagement.entity.Teacher;
import com.sagar88.schoolmanagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Class> getClassesForTeacher(Long teacherId) {
        return teacherRepository.findClassesByTeacherId(teacherId);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
