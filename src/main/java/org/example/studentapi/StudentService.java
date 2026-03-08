package org.example.studentapi;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@Transactional(readOnly = true)
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

    @Transactional
    public Student newStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Transactional
    public Student edit(Long id, Student student) {

       Student existing = studentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

       existing.setName(student.getName());
       existing.setGrade(student.getGrade());

       return studentRepository.save(existing);
    }

    @Transactional
    public void delete(Long id) {
        Student existing = studentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        studentRepository.delete(existing);
    }
}
