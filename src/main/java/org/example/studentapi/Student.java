package org.example.studentapi;

import jakarta.persistence.*;

@Entity
@Table(name = "student_db")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int grade; // оценка


    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "name: " + name + ", " + "grade: " + grade;
    }
}