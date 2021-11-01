public class Chicken implements Command {
 
	private Chef chef;
	 
	Chicken(Chef chef) {
		this.chef=chef;
	}
	 
	public void execute() {
		chef.chicken();
	}
	 
}
 
