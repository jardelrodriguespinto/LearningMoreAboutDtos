package com.learningdto.springbootlearningmoreaboutdtos.repository;

import com.learningdto.springbootlearningmoreaboutdtos.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
