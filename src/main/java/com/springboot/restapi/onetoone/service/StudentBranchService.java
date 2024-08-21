package com.springboot.restapi.onetoone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.restapi.onetoone.model.StudentBranch;
import com.springboot.restapi.onetoone.repository.StudentBranchRepository;

@Service
public class StudentBranchService {
	
	
	@Autowired
	private StudentBranchRepository studentBranchRepository;
	
	
	public List<StudentBranch> findAll(){
		return studentBranchRepository.findAll();
	}
	
	public StudentBranch save(StudentBranch student) {
		return studentBranchRepository.save(student);
	}
	
	public StudentBranch findById(Long id) {
		return studentBranchRepository.findById(id).orElse(null);
	}
	
	public  void deleteById(Long id) {
		studentBranchRepository.deleteById(id);
	}
	
	public Page<StudentBranch> findAll(Pageable pageable){
		return studentBranchRepository.findAll(pageable);
	}
	
	public List<StudentBranch> getAllBranches(Sort sort) {
        return studentBranchRepository.findAll(sort); 
    }
}
