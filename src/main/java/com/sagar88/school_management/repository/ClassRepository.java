package com.sagar88.school_management.repository;

import com.sagar88.school_management.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long> {
    @Query("SELECT c FROM Class c WHERE c.standard = :standard")
    List<com.sagar88.school_management.entity.Class> findClassesByStandard(@Param("standard") String standard);

    @Query("SELECT c FROM Class c WHERE c.subject = :subject")
    List<com.sagar88.school_management.entity.Class
            > findClassesBySubject(@Param("subject") String subject);
}

