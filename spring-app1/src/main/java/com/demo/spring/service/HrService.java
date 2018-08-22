package com.demo.spring.service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

public class HrService {
	
	EmpDao dao;
	
	
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}


	public String registerEmployee(int empId, String name, String city, double salary) {
		
		String response = dao.save(new Emp(empId, name, city, salary));
		return response;

	}
}
