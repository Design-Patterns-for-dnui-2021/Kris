package singleton;

public class Task {
 
	private int id;
	 
	private String name;
	 
	private int priority;	 
	
	public Task(int id, int priority, String name) {
		this.id = id;
		this.priority = priority;
		this.name = name;
	}
	 
	public void taskInfo() {
		System.out.println("ID\t\t:" + id);
		System.out.println("Priority\t:" + priority);
		System.out.println("Name\t\t:" + name);		
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getID() {
		return id;
	}
	 
}
 
