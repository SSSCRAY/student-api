package org.example.studentapi;

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
