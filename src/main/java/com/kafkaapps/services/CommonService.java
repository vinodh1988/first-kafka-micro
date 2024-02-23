package com.kafkaapps.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafkaapps.entities.Person;
import com.kafkaapps.entities.Task;

import jakarta.annotation.PostConstruct;

@Service
public class CommonService {
    Map<String,Integer> partitions=new HashMap<String,Integer>();
    
    @PostConstruct
	public void init() {
    	partitions.put("erp",0);
    	partitions.put("api", 1);
    	partitions.put("db", 2);
    }
    
	@Autowired
	private KafkaTemplate<String, Person> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, Task> taskTemplate;
	
	public void processPerson(Person p) {
		kafkaTemplate.send("messages",p);
	}
	
	public void processTask(String project, Task t) {
		Integer partition=partitions.get(project);
		if(partition!=null)
		     taskTemplate.send("tasks",partition, project, t);
		
	}
}
