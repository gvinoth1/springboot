package com.demo.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.Emp;

@Service
public class EmpJpaData {
	@Autowired
	EmpRepository repo;

	public ResponseEntity findById(int id) {
		Optional<Emp> o = repo.findById(id);
		if (o.isPresent()) {
			return ResponseEntity.ok(o.get());
		} else {
			return ResponseEntity.ok("Employee Does not exist..");
		}
	}

	@Cacheable("empListCache")
	public ResponseEntity getEmpLIST() {
		System.out.println("Find all method called..");
		return ResponseEntity.ok(repo.findAll());
	}

	public String save(Emp e) {
		if (repo.existsById(e.getEmpId())) {
			return  "The Employee Already exists";			
		} else {
			repo.save(e);
			return "Emp saved";
		}
	}
}
