package com.demo.spring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
	
	@Query(value="select e from Emp e where e.name like '%V%'")
	public List<Emp> getNamesWithS();
	
	
}
