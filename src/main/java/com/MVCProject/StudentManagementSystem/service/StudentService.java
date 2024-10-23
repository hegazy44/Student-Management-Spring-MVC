package com.MVCProject.StudentManagementSystem.service;

import com.MVCProject.StudentManagementSystem.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
    public Student saveStudent(Student student);
    public Student getById(int id);
    public void deleteById(int id);
}
