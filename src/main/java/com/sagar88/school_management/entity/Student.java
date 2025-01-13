package com.sagar88.school_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    private Long id; // Same ID as User

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @ManyToMany(mappedBy = "students")
    private List<Class> classes; // Classes taught by the teacher

    @Column(nullable = false)
    private String standard; // e.g., "4th", "5th"
}
