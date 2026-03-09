package org.example.studentapi.controller;

import jakarta.validation.Valid;
import org.example.studentapi.dto.StudentRequestDTO;
import org.example.studentapi.dto.StudentResponseDTO;
import org.example.studentapi.service.StudentService;
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
    public ResponseEntity<List<StudentResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @GetMapping("/passed")
    public ResponseEntity<List<StudentResponseDTO>> getPassed() {
        return ResponseEntity.ok(service.passed());
    }

    @PostMapping("/new")
    public ResponseEntity<StudentResponseDTO> addStudent(@Valid @RequestBody StudentRequestDTO request) {
        return ResponseEntity.status(201).body(service.newStudent(request));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<StudentResponseDTO> editStudent(@PathVariable Long id, @Valid @RequestBody StudentRequestDTO request) {
        return ResponseEntity.ok(service.edit(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}




