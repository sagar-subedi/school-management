package com.sagar88.school_management.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDTO {
    private Long id;
    private String username;
    private String standard;
    private List<ClassDTO> classes;

    // Getters and Setters
}

