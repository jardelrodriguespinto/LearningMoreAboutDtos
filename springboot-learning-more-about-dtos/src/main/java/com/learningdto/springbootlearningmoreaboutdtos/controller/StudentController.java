package com.learningdto.springbootlearningmoreaboutdtos.controller;

import com.learningdto.springbootlearningmoreaboutdtos.dto.StudentDto;
import com.learningdto.springbootlearningmoreaboutdtos.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    // get all students
    @GetMapping
    public ResponseEntity<?> getAllStudents(){
        try{
            List<StudentDto> students = studentService.getAllStudents();
            return new ResponseEntity<>(students,HttpStatus.OK);
        } catch (ResponseStatusException error){
            return new ResponseEntity<>(error.getMessage(), error.getStatusCode());
        }
    }
    //get student by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        try{
            studentService.getStudentById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResponseStatusException error){
            return new ResponseEntity<>(error.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    // create a student
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDto newStudentDto){
        try{
            StudentDto studentDto = studentService.createStudent(newStudentDto);
            return new ResponseEntity<>(studentDto,HttpStatus.CREATED);
        } catch (ResponseStatusException error){
            return new ResponseEntity<>(error.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    //update student
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){
        try{
            StudentDto student = studentService.updateStudent(id, studentDto);
            return new ResponseEntity<>(student,HttpStatus.OK);
        } catch (ResponseStatusException error){
            return new ResponseEntity<>(error.getMessage(),error.getStatusCode());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id){
        try{
            String message = studentService.deleteStudentById(id);
            return new ResponseEntity<>(message,HttpStatus.OK);
        } catch (ResponseStatusException error){
            return new ResponseEntity<>(error.getMessage(),error.getStatusCode());
        }
    }
}
