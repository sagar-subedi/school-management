package com.sagar88.school_management.dto;

import lombok.Data;

@Data
public class ResultDTO {
    private Long id;
    private StudentDTO student;
    private Integer marks;
    private ExamDTO exam;

}
