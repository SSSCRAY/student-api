package org.example.studentapi;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @GetMapping("/passed")
    public ResponseEntity<List<Student>> getPassed() {
        return ResponseEntity.ok(service.passed());
    }

    @PostMapping("/new")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.status(201).body(service.newStudent(student));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        return ResponseEntity.ok(service.edit(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}




