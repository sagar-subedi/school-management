package com.sagar88.school_management.repository;

import com.sagar88.school_management.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    @Query("SELECT r FROM Result r WHERE r.exam.id = :examId")
    List<Result> findResultsByExamId(@Param("examId") Long examId);

    List<Result> findResultsByStudentId(Long studentId);

    @Query("SELECT r FROM Result r WHERE r.student.id = :studentId AND r.exam.id = :examId")
    List<Result> findResultsByStudentAndExam(@Param("studentId") Long studentId, @Param("examId") Long examId);
}

