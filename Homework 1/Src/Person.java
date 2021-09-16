public class Person extends Subject implements Observer, Member {
 
	private String name;
	 
	public Person(String name) {
		this.name = name;
	}
	 
	public void action() {
		System.out.println(this.name + ", your teamate has been attacked, consider to take an action!");
	}
	 
	public void update() {
		this.action();
	}
	 
	public void beat() {
		System.out.println(this.name + " has been attacked");
		this.notifyObservers();
	}
	 
}
 
