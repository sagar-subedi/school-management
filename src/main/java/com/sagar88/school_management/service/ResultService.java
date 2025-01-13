package com.sagar88.school_management.service;

import com.sagar88.school_management.dto.MarksEnterDTO;
import com.sagar88.school_management.dto.ResultDTO;
import com.sagar88.school_management.entity.Exam;
import com.sagar88.school_management.entity.Result;
import com.sagar88.school_management.entity.Student;
import com.sagar88.school_management.rabbitmq.ResultPublisher;
import com.sagar88.school_management.repository.ExamRepository;
import com.sagar88.school_management.repository.ResultRepository;
import com.sagar88.school_management.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultService {


    @Autowired
    private ResultPublisher resultPublisher;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamRepository examRepository;

    public Result addResult(Long studentId, Long examId, Integer marks) {
        Result result = new Result();
        Exam exam = examRepository.findById(examId).orElseThrow();
        Student student = studentRepository.findById(studentId).orElseThrow();
        result.setExam(exam);
        result.setStudent(student);
        result.setMarks(marks);
        return resultRepository.save(result);
    }

    public void publishResult(Long examId){
        List<Result> results = resultRepository.findResultsByExamId(examId);
        for(Result result: results){
            String message = MessageFormat.format( "{4}|result|Dear Student, Your marks for {0} exam of {1} is {2} out of {3}. \n Thanks.",result.getExam().getTerm(), result.getExam().getClassEntity().getSubject(), result.getMarks(), result.getExam().getFullMarks(), result.getStudent().getUser().getEmail());
            resultPublisher.publishResult(message);
        }
    }

    @Transactional
    public void addResult(Long examId, List<MarksEnterDTO> marks){
        for(MarksEnterDTO mark: marks){
            Exam exam = examRepository.findById(examId).orElseThrow();
            Student student = studentRepository.findById(mark.getStudentId()).orElseThrow();
            Result newResult = new Result();
            newResult.setExam(exam);
            newResult.setMarks(mark.getMarks());
            newResult.setStudent(student);
            resultRepository.save(newResult);
        }
    }

    public List<Result> getResultsByExam(Long examId) {
        return resultRepository.findResultsByExamId(examId);
    }

    public List<Result> getResultForStudentForTerm(Long studentId, String term, String year){
        return resultRepository.findResultsByStudentId(studentId).stream().filter(
                result -> result.getExam().getTerm().equals(term) && result.getExam().getYear().equals(year)
        ).collect(Collectors.toList());
    }

    public List<Result> getResultsByStudentAndExam(Long studentId, Long examId) {
        return resultRepository.findResultsByStudentAndExam(studentId, examId);
    }

    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }
}

