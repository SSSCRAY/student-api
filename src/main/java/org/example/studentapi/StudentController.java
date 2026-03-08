package org.example.studentapi;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @GetMapping("/passed")
    public List<Student> getPassed() {
        return service.passed();
    }

    @PostMapping("/new")
    public Student addStudent(@Valid @RequestBody Student student) {
        return service.newStudent(student);
    }

    @PutMapping("/edit/{id}")
    public Student editStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        return service.edit(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
