package dev.marvin.studentmanagement.controller;

import dev.marvin.studentmanagement.domain.Student;
import dev.marvin.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{studentId}")
    ResponseEntity<Student> getStudentById(@PathVariable("studentId") Long studentId) {
        Student studentResponse = studentService.getStudentById(studentId);
        return ResponseEntity.ok(studentResponse);
    }

    @PostMapping
    ResponseEntity<Student> createStudent(@RequestBody Student newStudent) {
        Student createdStudent = studentService.createStudent(newStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/{studentId}")
    ResponseEntity<Student> updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student studentUpdate) {
        Student updatedStudent = studentService.updateStudent(studentId, studentUpdate);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{studentId}")
    ResponseEntity<Student> deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

}
