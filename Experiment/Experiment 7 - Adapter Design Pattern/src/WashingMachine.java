
public class WashingMachine extends ThreeSocket {
	
	@Override
	public void plug() {
		System.out.println("Washing machine is plugged");
	}
	
	@Override
	public void unplug() {
		System.out.println("Washing machine is unplugged");
	}
}
