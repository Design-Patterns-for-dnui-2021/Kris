
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WashingMachine washingmachine = new WashingMachine();
		TV tv = new TV();
		
		washingmachine.plug();
		washingmachine.unplug();
		
		tv.plug();
		tv.unplug();
		
	}

}
