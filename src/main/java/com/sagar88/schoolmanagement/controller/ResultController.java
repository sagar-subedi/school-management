package com.sagar88.schoolmanagement.controller;

import com.sagar88.schoolmanagement.dto.MarksEnterDTO;
import com.sagar88.schoolmanagement.dto.ResultDTO;
import com.sagar88.schoolmanagement.entity.Result;
import com.sagar88.schoolmanagement.service.ResultService;
import com.sagar88.schoolmanagement.utils.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping
    public ResponseEntity<Result> addResult(@RequestParam Long studentId, @RequestParam Long examId, @RequestParam Integer marks ) {
        Result createdResult = resultService.addResult(studentId, examId, marks);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/publish/{examId}")
    public ResponseEntity<Boolean> publishResult(@PathVariable Long examId){
        resultService.publishResult(examId);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/{examId}")
    public ResponseEntity<Result> addResultForExam(@PathVariable Long examId, @RequestBody List<MarksEnterDTO> marks) {
        resultService.addResult(examId, marks);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResultDTO>> getResultForStudentOfTerm(@RequestParam Long studentId, @RequestParam String term, @RequestParam String year) {
        List<Result> results = resultService.getResultForStudentForTerm(studentId, term, year);
        return new ResponseEntity<>(results.stream().map(DTOMapper::toResultDTO).collect(Collectors.toList()), HttpStatus.OK);
    }


    @GetMapping("/exam/{examId}")
    public ResponseEntity<List<Result>> getResultsByExam(@PathVariable Long examId) {
        List<Result> results = resultService.getResultsByExam(examId);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }


    @GetMapping("/student/{studentId}/exam/{examId}")
    public ResponseEntity<List<Result>> getResultsByStudentAndExam(
            @PathVariable Long studentId,
            @PathVariable Long examId) {
        List<Result> results = resultService.getResultsByStudentAndExam(studentId, examId);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @DeleteMapping("/{resultId}")
    public ResponseEntity<Void> deleteResult(@PathVariable Long resultId) {
        resultService.deleteResult(resultId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

