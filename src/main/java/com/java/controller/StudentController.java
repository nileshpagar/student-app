package com.java.controller;

import com.java.dto.Student;
import com.java.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    List<Student> all() {
        return studentService.allStudents();
    }

    @PostMapping("/students")
    Student newStudent(@RequestBody Student newStudent) {
        return studentService.addStudent(newStudent);
    }

    @GetMapping("/students/{id}")
    Student one(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PutMapping("/students/{id}")
    Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        newStudent.setId(id);
        return studentService.updateStudent(newStudent);
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
