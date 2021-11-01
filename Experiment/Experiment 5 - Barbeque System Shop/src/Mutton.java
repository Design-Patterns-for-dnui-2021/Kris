public class Mutton implements Command {
 	 
	private Chef chef;
	 
	Mutton(Chef chef) {
		this.chef=chef;
	}
	 
	public void execute() {
		chef.mutton();
	}
	 
}
 
