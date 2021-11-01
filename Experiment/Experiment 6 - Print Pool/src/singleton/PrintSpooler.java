package singleton;
import java.util.ArrayList;
import java.util.Optional;

public class PrintSpooler {
 
	private static PrintSpooler instance = null;
	 
	private ArrayList<Task> tasks = new ArrayList();
	 
	public static PrintSpooler getInstance() {
		if (instance == null) {
			instance = new PrintSpooler();
		} else {
			throw new Error("Print Spool already instantiated!");
		}
		return instance;
	}
	 
	public void addTask(int id, int priority, String name) {
		tasks.add(new Task(id, priority, name));
	}
	
	public void delete(int id) {
		Optional<Task> task = tasks.stream().filter((item) -> item.getID() == id).findFirst();
		if (task.isPresent()) {
			tasks.remove(task.get());
		}
	}
	
	public void priority(int id, int priority) {
		Optional<Task> task = tasks.stream().filter((item) -> item.getID() == id).findFirst();
		if (task.isPresent()) {
			int index = tasks.indexOf(task.get());
			task.get().setPriority(priority);
			tasks.set(index, task.get());
		}
	}
	
	public void display() {
		tasks.forEach((item) -> item.taskInfo());
	}
	 
}
 
