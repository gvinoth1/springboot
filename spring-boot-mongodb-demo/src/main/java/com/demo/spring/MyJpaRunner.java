package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyJpaRunner implements CommandLineRunner {

	@Autowired
	EmpRepository repo;

	@Override
	public void run(String... args) throws Exception {
		//repo.deleteAll();
		
		repo.insert(new Emp("121", "Bike", "Citty", 494));
		repo.findAll().forEach(e -> {System.out.println(e);});
		
		

	}

}
