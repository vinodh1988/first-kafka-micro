package com.kafkaapps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaapps.entities.Person;
import com.kafkaapps.entities.Task;
import com.kafkaapps.services.CommonService;

@RestController
@RequestMapping("/api")
public class FirstController {

	@Autowired
	private CommonService service;
	@PostMapping("/people")
	public ResponseEntity<String> store(@RequestBody Person person) {
		service.processPerson(person);
		return new ResponseEntity<String>("Successfuly Processed",HttpStatus.OK);
	}
	
	@PostMapping("/task")
	public ResponseEntity<String> store(@RequestParam("project") String project,@RequestBody Task task) {
		//service.processPerson(task);
		service.processTask(project, task);
		return new ResponseEntity<String>("Successfuly Processed",HttpStatus.OK);
	}
}
