package com.learningdto.springbootlearningmoreaboutdtos.converter;

import com.learningdto.springbootlearningmoreaboutdtos.dto.StudentDto;
import com.learningdto.springbootlearningmoreaboutdtos.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentConverter {
    public static StudentDto convertEntityToDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setUsername(student.getUsername());
        studentDto.setPassword(student.getPassword());
        return studentDto;
    }
    public static List<StudentDto> convertEntityToDto(List<Student> students) {
        List<StudentDto> studentDtos = new ArrayList<>();
        for(Student student : students){
            StudentDto studentDto = convertEntityToDto(student);
            studentDtos.add(studentDto);
        }
        return studentDtos;
    }
    public static Student convertDtoToEntity(StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setUsername(studentDto.getUsername());
        student.setPassword(studentDto.getPassword());
        return student;
    }

}
