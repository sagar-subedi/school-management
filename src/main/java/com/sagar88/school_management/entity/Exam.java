package com.sagar88.school_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String term; // e.g., "Mid-Term", "Final"

    @Column(nullable = false)
    private Integer fullMarks;

    @Column(nullable = false)
    private Integer passMarks;

    @ManyToOne
    private Class classEntity;
}
