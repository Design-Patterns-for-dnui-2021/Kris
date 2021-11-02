
public class TV extends TwoSocket {
	
	@Override
	public void plug() {
		System.out.println("TV is plugged");
	}
	
	@Override
	public void unplug() {
		System.out.println("TV is unplugged");
	}
}
