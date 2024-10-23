package com.MVCProject.StudentManagementSystem.serviceImp;

import com.MVCProject.StudentManagementSystem.entity.Student;
import com.MVCProject.StudentManagementSystem.repository.StudentRepository;
import com.MVCProject.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {

         List<Student> studentList =  studentRepository.findAll();
        return studentList;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
