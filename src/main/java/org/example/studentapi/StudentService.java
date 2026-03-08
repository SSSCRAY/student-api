package org.example.studentapi;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Student> passed() {
        return studentRepository.findByGradeGreaterThanEqual(60);
    }

    public Student newStudent(Student student) {
        if(student.getName() == null || student.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Имя должно быть обязательными");
        }

        studentRepository.save(student);
        return student;
    }

    public Student edit(Long id, Student student) {

       Student existing = studentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

       existing.setName(student.getName());
       existing.setGrade(student.getGrade());

       return studentRepository.save(existing);
    }

    public void delete(Long id) {
        Student existing = studentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        studentRepository.delete(existing);
    }
}
