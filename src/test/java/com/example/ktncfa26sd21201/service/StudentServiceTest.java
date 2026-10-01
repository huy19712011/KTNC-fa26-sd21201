package com.example.ktncfa26sd21201.service;

import com.example.ktncfa26sd21201.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {

        studentService = new StudentService();
    }

    // addStudent()
    // student valid
    // student invalid: name, age, mark

    @Test
    @DisplayName("Valid Student")
    void addStudentWithValidStudent() {

        Student student = new Student(1, "A", 20, 9.0);
        studentService.addStudent(student);

        assertEquals(20, studentService.getStudentById(1).getAge());
        assertEquals("A", studentService.getStudentById(1).getName());
    }

    @Test
    @DisplayName("Student is Null")
    void addStudentWithNull() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> studentService.addStudent(null));
        assertEquals("Student can not be null", exception.getMessage());
    }

    @Test
    @DisplayName("Name is empty")
    void addStudentWithInvalidName() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                studentService.addStudent(new Student(1, "", 20, 9.0)));
        assertEquals("Name must not be null or empty", exception.getMessage());
    }
}