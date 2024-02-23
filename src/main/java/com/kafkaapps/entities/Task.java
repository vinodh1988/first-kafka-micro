package com.kafkaapps.entities;

public class Task {
	
    private Integer communicationId;
    private String task;
    private String issue;
    
    public Task() {}
    
	public Task(Integer communicationId, String task, String issue) {
		super();
		this.communicationId = communicationId;
		this.task = task;
		this.issue = issue;
	}
	public Integer getCommunicationId() {
		return communicationId;
	}
	public void setCommunicationId(Integer communicationId) {
		this.communicationId = communicationId;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
    
    
    
}
