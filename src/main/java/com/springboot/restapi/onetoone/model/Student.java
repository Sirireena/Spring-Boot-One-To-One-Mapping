package com.springboot.restapi.onetoone.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="stu_tbl")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="branch_id",referencedColumnName="id")
	private StudentBranch branch;


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
		this.name = name;
	}


	public StudentBranch getBranch() {
		return branch;
	}


	public void setBranch(StudentBranch branch) {
		this.branch = branch;
	}


	public Student(String name) {
		super();
		this.name = name;
	}


	public Student() {
		super();
	}
	
	

}
