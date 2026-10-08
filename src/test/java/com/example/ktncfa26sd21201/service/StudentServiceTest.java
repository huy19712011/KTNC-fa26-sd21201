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

    @Test
    @DisplayName("Age < 18")
    void addStudentWithInvalidAge() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                studentService.addStudent(new Student(1, "A", 15, 9.0)));
        assertEquals("Age must be greater than 18", exception.getMessage());

    }

    // update
    @Test
    void updateStudentWithValidStudent() {

        Student student = new Student(1, "A", 20, 9.0);
        studentService.addStudent(student);

        student.setName("B");
        student.setAge(21);
        student.setMark(8.0);

        studentService.updateStudent(student);

        assertEquals("B", studentService.getStudentById(1).getName());
        assertEquals(21, studentService.getStudentById(1).getAge());
        assertEquals(8.0, studentService.getStudentById(1).getMark());
    }

    @Test
    void updateStudentWithNull() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> studentService.updateStudent(null));
        assertEquals("Student can not be null", exception.getMessage());
    }

    @Test
    void updateStudentWithInvalidName() {

        Student student = new Student(1, "A", 20, 9.0);
        studentService.addStudent(student);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                studentService.updateStudent(new Student(1, "", 21, 8.0)));
        assertEquals("Name must not be null or empty", exception.getMessage());

    }


}