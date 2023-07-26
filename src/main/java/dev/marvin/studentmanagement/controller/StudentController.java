package dev.marvin.studentmanagement.controller;

import dev.marvin.studentmanagement.domain.Student;
import dev.marvin.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{studentId}")
    ResponseEntity<Student> getStudentById(@PathVariable("studentId") Long studentId){
        Student studentResponse = studentService.getStudentById(studentId);
        return ResponseEntity.ok(studentResponse);
    }

}
