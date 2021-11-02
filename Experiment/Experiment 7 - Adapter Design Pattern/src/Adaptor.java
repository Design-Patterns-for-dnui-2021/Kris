public class Adaptor implements ThreeSocket{
	TwoSocket twosocket;
	
	public Adaptor(TwoSocket twosocket) {
		this.twosocket = twosocket;
	}
	

	public void plug() {
		TwoSocket.plug();
	}
	

	public void unplug() {
		TwoSocket.unplug();
	}
}
