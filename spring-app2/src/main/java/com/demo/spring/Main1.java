package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.service.HrService;

public class Main1 {
	
	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);				
		HrService service = (HrService) ctx.getBean("hrService");
		System.out.println(service.registerEmployee(10001, "Vinoth Gangadharan", "Chennai", 8000));	
	}

}
