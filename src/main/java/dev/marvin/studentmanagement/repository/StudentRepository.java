package dev.marvin.studentmanagement.repository;

import dev.marvin.studentmanagement.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query(value = "SELECT * FROM tbl_students", nativeQuery = true)
    List<Student> findAllStudents();
}
