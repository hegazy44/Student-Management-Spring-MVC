package com.MVCProject.StudentManagementSystem.controller;
import com.MVCProject.StudentManagementSystem.entity.Student;
import com.MVCProject.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {
    @Autowired
	private StudentService service;

    @GetMapping("/home")
    public String showHomePage() {
	    return "home";
	}
	@GetMapping("/students")
	public String getAllStudents(Model model){
	   model.addAttribute("student",service.getAllStudents());
       return "students";
	}
	@GetMapping("students/new")
	public String createStudentForm(Model model){
		Student student = new Student();
		model.addAttribute("student",student);
		return "create-student";
	}
    @PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student){
		service.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id ,Model model ){
		model.addAttribute("student",service.getById(id));
		return "edit_student";

	}
    @PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id , @ModelAttribute("student") Student student){
		Student existingStudent= service.getById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
	    service.saveStudent(existingStudent);
		return "redirect:/students";
	}
@GetMapping("/students/{id}")
	public String deleteBYId(@PathVariable int id){
		service.deleteById(id);
		return "redirect:/students";
	}



}
