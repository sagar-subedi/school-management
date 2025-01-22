package com.sagar88.schoolmanagement.service;

import com.sagar88.schoolmanagement.repository.ClassRepository;
import com.sagar88.schoolmanagement.entity.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public com.sagar88.schoolmanagement.entity.Class createClass(com.sagar88.schoolmanagement.entity.Class newClass) {
        return classRepository.save(newClass);
    }

    public List<com.sagar88.schoolmanagement.entity.Class> getClassesByStandard(String standard) {
        return classRepository.findClassesByStandard(standard);
    }

    public List<Class> getClassesBySubject(String subject) {
        return classRepository.findClassesBySubject(subject);
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}
