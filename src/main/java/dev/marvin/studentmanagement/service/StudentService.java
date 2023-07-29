package dev.marvin.studentmanagement.service;

import dev.marvin.studentmanagement.dao.StudentDao;
import dev.marvin.studentmanagement.domain.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentDao studentDao;

    public List<Student> getAllStudents() {
        try {
            log.info("fetching students...");
            return studentDao.getAllStudents();
        } catch (Exception e) {
            log.info("Error occurred", e);
        }
        return null;
    }

    public Student getStudentById(Long studentId) {
        try {
            log.info("Fetching student with id [%s]".formatted(studentId));
            return studentDao.getStudentById(studentId).orElse(null);
        } catch (Exception e) {
            log.info("Error occurred", e);
        }
        return null;
    }

    public Student createStudent(Student newStudent) {
        try {
            log.info("Saving...");
            studentDao.saveStudent(newStudent);
            log.info("Saved {}", newStudent);
        } catch (Exception e) {
            log.info("Error occurred", e);
        }
        return null;
    }

    public Student updateStudent(Long studentId, Student studentUpdate) {
        try {
            log.info("Updating student with id [%s]".formatted(studentId));

            Student student = studentDao.getStudentById(studentId).orElse(null);

            if (student != null) {
                student.setFirstName(studentUpdate.getFirstName());
                student.setLastName(studentUpdate.getLastName());
                student.setEmail(studentUpdate.getEmail());
                student.setPhone(studentUpdate.getPhone());
                student.setAddress(studentUpdate.getAddress());
                student.setCourse(studentUpdate.getCourse());

                studentDao.saveStudent(student);
                log.info("Update successful");
            }
        } catch (Exception e) {
            log.info("Error occurred", e);
        }
        return null;
    }

    public void deleteStudent(Long studentId) {
        try {
            log.info("Deleting student with id [%s]".formatted(studentId));
            Student student = studentDao.getStudentById(studentId).orElse(null);

            if (student != null) {
                studentDao.deleteStudent(student);
                log.info("Student deleted successfully");
            }
        } catch (Exception e) {
            log.info("Error occurred", e);
        }
    }

}
