package com.sagar88.school_management.controller;

import com.sagar88.school_management.dto.MarksEnterDTO;
import com.sagar88.school_management.dto.ResultDTO;
import com.sagar88.school_management.entity.Result;
import com.sagar88.school_management.service.ResultService;
import com.sagar88.school_management.utils.DTOMapper;
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

    /**
     * Add a new result.
     * @param result The result object to be added.
     * @return The created result.
     */
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


    /**
     * Get results by exam ID.
     * @param examId The ID of the exam.
     * @return List of results for the given exam.
     */
    @GetMapping("/exam/{examId}")
    public ResponseEntity<List<Result>> getResultsByExam(@PathVariable Long examId) {
        List<Result> results = resultService.getResultsByExam(examId);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    /**
     * Get results by student ID and exam ID.
     * @param studentId The ID of the student.
     * @param examId The ID of the exam.
     * @return List of results for the given student and exam.
     */
    @GetMapping("/student/{studentId}/exam/{examId}")
    public ResponseEntity<List<Result>> getResultsByStudentAndExam(
            @PathVariable Long studentId,
            @PathVariable Long examId) {
        List<Result> results = resultService.getResultsByStudentAndExam(studentId, examId);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    /**
     * Delete a result by ID.
     * @param resultId The ID of the result to delete.
     * @return HTTP status indicating the outcome.
     */
    @DeleteMapping("/{resultId}")
    public ResponseEntity<Void> deleteResult(@PathVariable Long resultId) {
        resultService.deleteResult(resultId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

