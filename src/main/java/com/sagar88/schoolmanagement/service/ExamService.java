package com.sagar88.schoolmanagement.service;

import com.sagar88.schoolmanagement.entity.Exam;
import com.sagar88.schoolmanagement.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    public List<Exam> getExamsByYearAndTerm(String year, String term) {
        return examRepository.findExamsByYearAndTerm(year, term);
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}
