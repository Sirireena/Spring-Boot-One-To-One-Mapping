package com.springboot.restapi.onetoone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.restapi.onetoone.model.Student;
import com.springboot.restapi.onetoone.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	public Student findById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public  void deleteById(Long id) {
		studentRepository.deleteById(id);
	}
	
	public Page<Student> findAll(Pageable pageable){
		return studentRepository.findAll(pageable);
	}
	
	public List<Student> getAllStudents(Sort sort) {
        return studentRepository.findAll(sort);
    }
}
