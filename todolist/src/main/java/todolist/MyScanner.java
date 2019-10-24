package todolist;

import java.util.Scanner;

public class MyScanner {
	
	public static final Scanner SC = new Scanner(System.in);
	
	public String ask() {
		System.out.println("What do you want to do? ->");
		System.out.println("Add a task ? (add)");
		System.out.println("A task is done ? (done)");
		System.out.println("Edit a task ? (edit)");
		System.out.println("Remove a task ? (remove)");
		System.out.println("Show version(s) of a task ? (versions)");
		return SC.nextLine().trim();
	}
	
	public Task addTask() {
		System.out.println("Add Task ->");
		System.out.println("Name:");
		String name = SC.nextLine();
		System.out.println("Description:");
		String description = SC.nextLine();
		System.out.println("Scanner : New Task Added <- ");
		return new Task(name, description);
		
	}
	
	public int askTaskDone(int max) {
		System.out.println("Done a Task ->");
		System.out.println("Number of the task");
		int index = max+1;
		while((index<0) || (index> max)) {
			index = Integer.parseInt(SC.nextLine());
		}
		System.out.println("Scanner : A task is done <- ");
		return index;
	}
	
	public int getTask(int max) {
		System.out.println("Task Number");
		int index = max+1;
		while((index<0) || (index> max)) {
			index = Integer.parseInt(SC.nextLine());
		}
		return index;
	}
	
	public String editName() {
		System.out.println("Name (nothing to skip) : ");
		return SC.nextLine().trim();
	}
	public String editDescription() {
		System.out.println("Description (nothing to skip) : ");
		return SC.nextLine().trim();
	}

	public boolean recupVersion(){
		System.out.println("Do you want set new a version? (y/n) ");
		String bool = SC.nextLine().trim();
		return bool.equals("y")? true : false;
	}
	
	

}
