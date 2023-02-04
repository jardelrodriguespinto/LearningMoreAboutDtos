package com.learningdto.springbootlearningmoreaboutdtos.service;

import com.learningdto.springbootlearningmoreaboutdtos.converter.StudentConverter;
import com.learningdto.springbootlearningmoreaboutdtos.dto.StudentDto;
import com.learningdto.springbootlearningmoreaboutdtos.entity.Student;
import com.learningdto.springbootlearningmoreaboutdtos.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // get all students
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return StudentConverter.convertEntityToDto(students);
    }
    //get student by id

    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id not found"));
        return StudentConverter.convertEntityToDto(student);
    }

    // create a student
    public StudentDto createStudent(StudentDto newStudentDto) {
        Student newStudent = StudentConverter.convertDtoToEntity(newStudentDto);
        Student student = studentRepository.save(newStudent);
        return StudentConverter.convertEntityToDto(student);
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id not found"));
            student.setName(studentDto.getName());
            student.setUsername(studentDto.getUsername());
            student.setPassword(studentDto.getPassword());
            studentRepository.save(student);
            return StudentConverter.convertEntityToDto(student);
    }

    public String deleteStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Id not found"));
        if(student.getId() == null){
            return null;
        }
        studentRepository.deleteById(id);
        return "Student deleted successfully!";
    }
}