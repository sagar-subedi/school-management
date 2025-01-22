package com.sagar88.schoolmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teachers")
public class Teacher {
    @Id
    private Long id; // Same ID as User

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @ManyToMany(mappedBy = "teachers")
    private List<Class> classes; // Classes taught by the teacher
}
