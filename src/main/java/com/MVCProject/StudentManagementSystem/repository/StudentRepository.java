package com.MVCProject.StudentManagementSystem.repository;

import com.MVCProject.StudentManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
