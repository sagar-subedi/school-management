package com.sagar88.school_management.repository;

import com.sagar88.school_management.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    @Query("SELECT e FROM Exam e WHERE e.year = :year AND e.term = :term")
    List<Exam> findExamsByYearAndTerm(@Param("year") String year, @Param("term") String term);
}
