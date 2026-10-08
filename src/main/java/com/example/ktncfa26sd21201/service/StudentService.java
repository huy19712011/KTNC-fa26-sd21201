package com.example.ktncfa26sd21201.service;

import com.example.ktncfa26sd21201.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    // CRUD: 5 methods
    // 1. add
    // 2. get by Id
    // 3. get all
    // 4. update
    // 5. delete

    public void addStudent(Student student) {

        if (student == null) {

            throw new IllegalArgumentException("Student can not be null");
        }

        students.add(student);
    }

    public Student getStudentById(long id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public void updateStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("Student can not be null");
        }

        for (int i = 0; i < students.size(); ++i) {
            if ( students.get(i).getId() == student.getId()) {
                students.set(i, student);
                return;
            }
            else {
                throw new IllegalArgumentException("Student with id " + student.getId() + " does not exist");
            }
        }
    }

}
