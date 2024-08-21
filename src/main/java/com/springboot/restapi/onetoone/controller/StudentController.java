package com.springboot.restapi.onetoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.restapi.onetoone.model.Student;
import com.springboot.restapi.onetoone.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
    public List<Student> getAllUsers() {
        return studentService.findAll();
    }
	
	@PostMapping
    public Student createUser(@RequestBody Student student) {
        return studentService.save(student);
    }
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.findById(id);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id,@RequestBody Student student) {
		student.setId(id);
		return studentService.save(student);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteById(id);
	}
	
	@GetMapping("/page")
	public Page<Student> getStudentPage(Pageable pageable){
		return studentService.findAll(pageable);
	}
	
	@GetMapping("/sorting")
	public List<Student> getAllStudents(
	        @RequestParam(required = false) String sortBy,
	        @RequestParam(defaultValue = "desc") String direction) {
	    
	    Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy != null ? sortBy : "id");
	    return studentService.getAllStudents(sort);
	}


}
