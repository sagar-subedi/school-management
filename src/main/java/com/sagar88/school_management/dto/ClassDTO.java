package com.sagar88.school_management.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClassDTO {
    private Long id;
    private String subject;
    private String standard;
    private List<SimpleTeacherDTO> teachers;

    // Getters and Setters
}
