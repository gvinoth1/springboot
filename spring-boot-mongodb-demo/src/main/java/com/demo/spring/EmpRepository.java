package com.demo.spring;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpRepository extends MongoRepository<Emp, String> {
	
	
	
	
}
