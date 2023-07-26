package dev.marvin.studentmanagement.service;

import dev.marvin.studentmanagement.dao.StudentDao;
import dev.marvin.studentmanagement.domain.Student;
import dev.marvin.studentmanagement.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentDao studentDao;

    public List<Student> getAllStudents(){
        try {
            log.info("fetching students...");
            return studentDao.getAllStudents();
        }catch (Exception e){
            log.info("Error occurred", e);
        }
        return null;
    }

    public Student getStudentById(Long studentId){
        try {
            log.info("Fetching student with id [%s]".formatted(studentId));
            return studentDao.getStudentById(studentId).orElseThrow(()-> new ResourceNotFoundException("student with id [%s] not found".formatted(studentId)));
        }catch (Exception e){
            log.info("Error occurred", e);
        }
        return null;
    }





}
