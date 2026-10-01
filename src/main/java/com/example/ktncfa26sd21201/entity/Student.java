package com.example.ktncfa26sd21201.entity;

public class Student {

    private long id;
    private String name;
    private int age;
    private double mark;

    public Student(long id, String name, int age, double mark) {
        setId(id);
        setName(name);
        setAge(age);
        setMark(mark);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        // validation
        if ( name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be null or empty");
        }

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // validation
        if ( age < 18) {
            throw new IllegalArgumentException("Age must be greater than 18");
        }

        this.age = age;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        // validation
        if ( mark < 0 || mark > 10) {
            throw new IllegalArgumentException("Mark must be between 0 and 10");
        }

        this.mark = mark;
    }
}
