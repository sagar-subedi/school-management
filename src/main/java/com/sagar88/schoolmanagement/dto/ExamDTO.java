package com.sagar88.schoolmanagement.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExamDTO {
    private Long id;
    private String year;
    private String term;
    private Integer fullMarks;
    private Integer passMarks;
    private List<ResultDTO> results;
    private ClassDTO classEntity;

    // Getters and Setters
}

