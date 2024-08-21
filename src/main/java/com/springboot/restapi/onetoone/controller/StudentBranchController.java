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

import com.springboot.restapi.onetoone.model.StudentBranch;
import com.springboot.restapi.onetoone.service.StudentBranchService;

@RestController
@RequestMapping("/branches")
public class StudentBranchController {
	
	@Autowired
	private StudentBranchService  sBranchService;
	
	
	@GetMapping
	public List<StudentBranch>  getAllBranches(){
		return sBranchService.findAll();
	}
	
	@PostMapping
	public StudentBranch createBranch(@RequestBody StudentBranch sBranch) {
		return sBranchService.save(sBranch);
	}
	
	@GetMapping("/{id}")
	public StudentBranch getBranchById(@PathVariable Long id) {
		return sBranchService.findById(id);
	}
	
	
	@PutMapping("/{id}")
	public StudentBranch updateBranch(@PathVariable Long id,@RequestBody StudentBranch sBranch) {
		sBranch.setId(id);
		return sBranchService.save(sBranch);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBranch(@PathVariable Long id,@RequestBody StudentBranch sBranch) {
		sBranchService.deleteById(id);
	}
	
	@GetMapping("/page")
	public Page<StudentBranch> getBranchPage(Pageable pageable){
		return sBranchService.findAll(pageable);
	}
	
	@GetMapping("/sorting")
	public List<StudentBranch> getAllBranches(
	        @RequestParam(required = false) String sortBy,
	        @RequestParam(defaultValue = "ASC") String direction) {
	    
	    Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy != null ? sortBy : "id");
	    return sBranchService.getAllBranches(sort);
	}


}
