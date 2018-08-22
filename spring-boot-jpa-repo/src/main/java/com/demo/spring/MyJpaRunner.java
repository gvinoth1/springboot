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
		repo.findAll().forEach(e-> {
			System.out.println(e.getName()+" from "+ e.getCity());
			});	
		
		System.out.println("Custom Query");
		repo.getNamesWithS().forEach(e -> {
			System.out.println("custom Query result " + e.getName());
		});
		
		System.out.println("????????????? "+repo.existsById(1201));
		System.out.println("????????????? "+repo.findById(new Integer(1201)));

	}

}
