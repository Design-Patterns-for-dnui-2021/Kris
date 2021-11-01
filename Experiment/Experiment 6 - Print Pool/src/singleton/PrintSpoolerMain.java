package singleton;

public class PrintSpoolerMain {
 
	private PrintSpooler printSpooler;
	 
	public static void main(String[] args) {
		PrintSpooler app = PrintSpooler.getInstance();
		app.addTask(1, 1, "Head First Design Pattern.pdf");
		app.addTask(2, 1, "Codeigniter 4.pdf");
		app.addTask(3, 1, "Fundamental of Phyton For Machine Learning.pdf");
		
		app.display();
		
		app.priority(2, 3);
		app.delete(1);
		
		System.out.println("Updated Tasks: ");
		app.display();
		


	}
	 
}
 
