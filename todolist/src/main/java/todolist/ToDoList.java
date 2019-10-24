package todolist;

import java.util.ArrayList;

public class ToDoList {
	
	private ArrayList<Task> tasks;
	private MyScanner scanner;
	
	public ToDoList() {
		this.tasks = new ArrayList<Task>();
		this.scanner = new MyScanner();
	}
	
	
	public ArrayList<Task> getTasks() {
		return this.tasks;
	}
	
	public void addTask() {
		this.tasks.add(this.scanner.addTask());
	}
	
	public void addTask(Task t) {
		this.tasks.add(t);
	}
	
	
	public Task getTask(int i) {
		return this.tasks.get(i);
	}
	
	public String toString() {
		String str = "";
		int i = 0;
		for(Task t : this.tasks) {
			str += "Task number: "+i+ "|"+ " Done: "+t.isDone()+" | Name: "+t.getName()+ " | Description: "+ t.getDescription() + " | Version(s): "+ t.getNumberOfVersions()+ "\n"; 
			i++;
		}
		return str;
	}

	public void ask() {
		String ask = this.scanner.ask();
		int max = this.tasks.size()-1;
		if(ask.equals("add")){
			Task t = this.scanner.addTask();
			this.addTask(t);
			System.out.println("ToDo : A Task has been added ! ");
			System.out.println("Your ToDoList");
			System.out.println(this.toString());
		}
		else if(ask.equals("done")) {
			int i = this.scanner.askTaskDone(max);
			this.tasks.get(i).done();
			System.out.println(this.toString());
		}
		else if(ask.equals("edit")) {
			int i = this.scanner.getTask(max);
			String newName = this.scanner.editName();
			if(!newName.equals(""))
				this.getTask(i).setName(newName);
			String newDesc = this.scanner.editDescription();
			if(!newDesc.equals(""))
				this.getTask(i).setDescritpion(newDesc);
			System.out.println("A Task has been edited");
			System.out.println(this.toString());
		}
		else if(ask.equals("remove")) {
			int i = this.scanner.getTask(max);
			this.getTasks().remove(this.tasks.get(i));
			System.out.println("A Task has been removed");
			System.out.println(this.toString());
		}
		else if(ask.equals("versions")) {
			int i = this.scanner.getTask(max);
			System.out.println(this.tasks.get(i).getVersions().toString());
		}
		
		else {
			System.out.println("Comprends pas..");
		}
		this.ask();
	}
}
