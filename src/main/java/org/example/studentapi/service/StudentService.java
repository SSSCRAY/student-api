package org.example.studentapi.service;

import org.example.studentapi.dto.StudentRequestDTO;
import org.example.studentapi.dto.StudentResponseDTO;
import org.example.studentapi.entity.Student;
import org.example.studentapi.mapper.StudentMapper;
import org.example.studentapi.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    public StudentService(StudentRepository studentRepository, StudentMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    public List<StudentResponseDTO> getAll() {
        return studentRepository.findAll().stream()
                .map(student -> mapper.toResponse(student))
                .collect(Collectors.toList());
    }

    public StudentResponseDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return mapper.toResponse(student);
    }
    
    public List<StudentResponseDTO> getByMinGrade(Integer minGrade) {
        return studentRepository.findByGradeGreaterThanEqual(minGrade)
                .stream()
                .map(student -> mapper.toResponse(student))
                .collect(Collectors.toList());
    }

    @Transactional
    public StudentResponseDTO newStudent(StudentRequestDTO requestDTO) {
        Student student = mapper.toEntity(requestDTO);
        Student studentSave = studentRepository.save(student);
        return mapper.toResponse(studentSave);

    }

    @Transactional
    public StudentResponseDTO edit(Long id, StudentRequestDTO requestDTO) {

       Student existing = studentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

       existing.setName(requestDTO.getName());
       existing.setGrade(requestDTO.getGrade());
       Student studentSave = studentRepository.save(existing);

       return mapper.toResponse(studentSave);
    }

    @Transactional
    public void delete(Long id) {
        Student existing = studentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        studentRepository.delete(existing);
    }
}
