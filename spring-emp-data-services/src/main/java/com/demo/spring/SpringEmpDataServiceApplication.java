package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringEmpDataServiceApplication {

	
	public static void main(String[] args) {	 
		
		SpringApplication.run(SpringEmpDataServiceApplication.class, args);
	}
}
