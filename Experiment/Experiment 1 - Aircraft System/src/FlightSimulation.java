public class FlightSimulation {
 
	private FlightType flightType;
	 
	private TakeOffType takeOffType;
	 
	public void setFlight(FlightType Flight) {
		this.flightType = Flight;
	}
	 
	public void setTakeOff(TakeOffType Takeoff) {
		this.takeOffType = Takeoff;
	}
	 
	public void startFlight() {
		this.flightType.startFlight();
	}
	
	public void startTakeoff() {
		this.takeOffType.startTakeoff();
	}
	
	public void displayInfo() {
		
	}
	 
}
 
