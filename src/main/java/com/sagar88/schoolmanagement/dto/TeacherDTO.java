package com.sagar88.schoolmanagement.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeacherDTO {
    private Long id;
    private String username;
    private List<ClassDTO> classes;
}

