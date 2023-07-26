package dev.marvin.studentmanagement.dao;

import dev.marvin.studentmanagement.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long studentId);
    Student saveStudent(Student student);
    void deleteStudent(Student student);
}
