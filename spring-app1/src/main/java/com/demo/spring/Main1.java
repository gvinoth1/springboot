package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.spring.service.HrService;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		
		HrService service = (HrService) ctx.getBean("hrService");
		System.out.println(service.registerEmployee(10001, "Vinoth Gangadharan", "Chennai", 8000));
	}

}
