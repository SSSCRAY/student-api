package org.example.studentapi.mapper;

import org.example.studentapi.dto.StudentRequestDTO;
import org.example.studentapi.dto.StudentResponseDTO;
import org.example.studentapi.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    // toResponse
    public StudentResponseDTO toResponse(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setGrade(student.getGrade());

        return dto;
    }

    // toEntity
    public Student toEntity(StudentRequestDTO requestDTO) {
        Student student = new Student();
        student.setName(requestDTO.getName());
        student.setGrade(requestDTO.getGrade());

        return student;
    }

}
