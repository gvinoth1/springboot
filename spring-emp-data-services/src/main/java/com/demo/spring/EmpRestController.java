package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;

@RestController
public class EmpRestController {

	@Autowired
	EmpJpaData dataService;

	@RequestMapping(path = "/greet", method = RequestMethod.GET)
	public String getMessage() {
		return "Hello from Spring REST";
	}

	@RequestMapping(path = "/emp/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getEmpById(@PathVariable("id") int id) {
		return dataService.findById(id);
	}
	
	@RequestMapping(
			path="/emp",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity getAll() {
				return ResponseEntity.ok(dataService.getEmpLIST());
			}
	
	@RequestMapping(
			path="/emp/save",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.TEXT_PLAIN_VALUE)

	public ResponseEntity saveEmp(@RequestBody Emp e) {
		return ResponseEntity.ok(dataService.save(e));		
	}	


}
