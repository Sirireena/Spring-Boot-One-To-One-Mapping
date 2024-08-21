package com.springboot.restapi.onetoone.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.restapi.onetoone.model.StudentBranch;

@Repository
public interface StudentBranchRepository extends JpaRepository<StudentBranch,Long>{

	List<StudentBranch> findAll(Sort sort);
}
