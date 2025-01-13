package com.sagar88.school_management.repository;

import com.sagar88.school_management.entity.Class;
import com.sagar88.school_management.entity.Result;
import com.sagar88.school_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT c FROM Class c JOIN c.students s WHERE s.id = :studentId")
    List<Class> findClassesByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT r FROM Result r WHERE r.student.id = :studentId")
    List<Result> findResultsByStudentId(@Param("studentId") Long studentId);
}
