package com.sagar88.school_management.repository;

import com.sagar88.school_management.entity.Class;
import com.sagar88.school_management.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("SELECT c FROM Class c JOIN c.teachers t WHERE t.id = :teacherId")
    List<Class> findClassesByTeacherId(@Param("teacherId") Long teacherId);
}

