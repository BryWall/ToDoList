package todolist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task {
	
	protected String name;
	protected String description;
	protected boolean done;
	protected ToDoList versions;
	
	public Task(String name, String description) {
		this.name = name;
		this.description = description;
		this.done = false;
		this.versions = new ToDoList();
	}
	
	public Task(String name, String description, ToDoList versions) {
		this.name = name;
		this.description = description;
		this.done = false;
		this.versions = versions;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public boolean isDone() {
		return this.done;
	}
	
	public ToDoList getVersions(){
		ToDoList list = this.versions;
		list.addTask(this);
		return list;
	}
	
	public void setName(String name) {
		Task oldTache = new Task(this.name,this.description,this.versions);
		this.versions.addTask(oldTache);
		this.name = name;
		
	}
	
	public void setDescritpion(String description) {
		Task oldTask = new Task(this.name,this.description,this.versions);
		this.versions.addTask(oldTask);
		this.description = description;
	}
	
	public void done() {
		this.done = true;
	}
	
	public Task getVersion(int i) {
		ToDoList list = this.versions;
		list.addTask(this);
		return list.getTask(i);
	}
	
	public int getNumberOfVersions() {
		return this.versions.getTasks().size()+1;
	}
	
	public String versionsToString() {
		return this.versions.toString();
	}
	
	

}
