package com.java.utils;

import com.java.dto.Student;
import com.java.respository.model.StudentEntity;

public class StudentUtils {

    public static Student buildStudentFromStudentEntity(StudentEntity studentEntity) {
        Student student = new Student();
        student.setId(studentEntity.getId());
        student.setFirstName(studentEntity.getFirstName());
        student.setLastName(studentEntity.getLastName());
        student.setClassName(studentEntity.getClassName());
        student.setNationality(studentEntity.getNationality());
        return student;
    }

    public static StudentEntity buildStudentEntityFromStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());
        studentEntity.setClassName(student.getClassName());
        studentEntity.setNationality(student.getNationality());
        return studentEntity;
    }

}
