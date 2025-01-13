package com.sagar88.school_management.utils;

import com.sagar88.school_management.dto.ClassDTO;
import com.sagar88.school_management.dto.ExamDTO;
import com.sagar88.school_management.dto.ResultDTO;
import com.sagar88.school_management.dto.SimpleClassDTO;
import com.sagar88.school_management.dto.SimpleTeacherDTO;
import com.sagar88.school_management.dto.StudentDTO;
import com.sagar88.school_management.dto.TeacherDTO;
import com.sagar88.school_management.dto.UserDTO;
import com.sagar88.school_management.entity.Exam;
import com.sagar88.school_management.entity.Result;
import com.sagar88.school_management.entity.Student;
import com.sagar88.school_management.entity.Teacher;
import com.sagar88.school_management.entity.Class;
import com.sagar88.school_management.entity.User;

import java.util.stream.Collectors;

public class DTOMapper {

    public static UserDTO toUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static StudentDTO toStudentDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setUsername(student.getUser().getUsername());
        dto.setStandard(student.getStandard());
        dto.setClasses(student.getClasses().stream().map(DTOMapper::toClassDTO).collect(Collectors.toList()));
        return dto;
    }

    public static TeacherDTO toTeacherDTO(Teacher teacher) {
        TeacherDTO dto = new TeacherDTO();
        dto.setId(teacher.getId());
        dto.setUsername(teacher.getUser().getUsername());
        dto.setClasses(teacher.getClasses().stream().map(DTOMapper::toClassDTO).collect(Collectors.toList()));
        return dto;
    }

    public static ClassDTO toClassDTO(Class classEntity) {
        ClassDTO dto = new ClassDTO();
        dto.setId(classEntity.getId());
        dto.setSubject(classEntity.getSubject());
        dto.setStandard(classEntity.getStandard());
        dto.setTeachers(classEntity.getTeachers().stream().map(DTOMapper::toSimpleTeacherDTO).collect(Collectors.toList()));
        return dto;
    }

    public static SimpleTeacherDTO toSimpleTeacherDTO(Teacher teacher) {
        SimpleTeacherDTO dto = new SimpleTeacherDTO();
        dto.setId(teacher.getId());
        dto.setName(teacher.getUser().getUsername());
        return dto;
    }

//    public static SimpleClassDTO toSimpleClassDTO(Class classEntity) {
//        SimpleClassDTO dto = new SimpleClassDTO();
//        dto.setId(classEntity.getId());
//        dto.setName(classEntity..getUser().getUsername());
//        return dto;
//    }

    public static ExamDTO toExamDTO(Exam exam) {
        ExamDTO dto = new ExamDTO();
        dto.setId(exam.getId());
        dto.setYear(exam.getYear());
        dto.setTerm(exam.getTerm());
        dto.setFullMarks(exam.getFullMarks());
        dto.setPassMarks(exam.getPassMarks());
        dto.setClassEntity(toClassDTO(exam.getClassEntity()));
//        dto.setResults(exam.getResults().stream().map(DTOMapper::toResultDTO).collect(Collectors.toList()));
        return dto;
    }

    public static ResultDTO toResultDTO(Result result) {
        ResultDTO dto = new ResultDTO();
        dto.setId(result.getId());
        dto.setExam(toExamDTO(result.getExam()));
        dto.setStudent(toStudentDTO(result.getStudent()));
        dto.setMarks(result.getMarks());
        return dto;
    }
}
