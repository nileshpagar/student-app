package com.java.service;

import com.java.dto.Student;
import com.java.respository.StudentRepository;
import com.java.respository.model.StudentEntity;
import com.java.utils.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student) {
        StudentEntity studentEntity = StudentUtils.buildStudentEntityFromStudent(student);
        studentRepository.save(studentEntity);
        student.setId(studentEntity.getId());
        return student;
    }

    public Student getStudent(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).get();
        Student student = StudentUtils.buildStudentFromStudentEntity(studentEntity);
        return student;
    }

    public List<Student> allStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(studentEntity -> students.add(StudentUtils.buildStudentFromStudentEntity(studentEntity)));
        return students;
    }

    public Student updateStudent(Student student) {
        StudentEntity studentEntity = studentRepository.findById(student.getId()).get();
        if (student.getFirstName() != null)
            studentEntity.setFirstName(student.getFirstName());
        if (student.getLastName() != null)
            studentEntity.setLastName(student.getLastName());
        if (student.getClassName() != null)
            studentEntity.setClassName(student.getClassName());
        if (student.getNationality() != null)
            studentEntity.setNationality(student.getNationality());
        studentRepository.save(studentEntity);
        return StudentUtils.buildStudentFromStudentEntity(studentEntity);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
