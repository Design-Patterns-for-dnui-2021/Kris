public class Customer {
 
	private Command Mutton, Chicken;
	
	Customer(Command Mutton, Command Chicken) {
		this.Mutton = Mutton;
		this.Chicken = Chicken;
	}
	
	public void orderMmutton() {
		Mutton.execute();
	}
	
	public void orderChicken() {
		Chicken.execute();
	}
	
}
 
