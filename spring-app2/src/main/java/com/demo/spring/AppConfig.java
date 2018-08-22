package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.spring.dao.EmpDaoJdbcImpl;
import com.demo.spring.service.HrService;

@Configuration
@ComponentScan(basePackages="com.demo.spring")
public class AppConfig {
/*	@Bean
	public HrService hrService() {		
		return new HrService();		
	}*/
	@Bean
	public EmpDaoJdbcImpl myDao() {		
		return new EmpDaoJdbcImpl();		
	}
}
