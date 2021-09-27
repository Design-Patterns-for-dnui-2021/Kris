public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlightSimulation Helicopter = new Helicopter();
		Helicopter.setFlight(new SubSonicFly());
		Helicopter.setTakeOff(new VerticalTakeOff());
		Helicopter.displayInfo();
		
		FlightSimulation Airplane = new AirPlane();
		Airplane.setFlight(new SubSonicFly());
		Airplane.setTakeOff(new LongDistanceTakeOff());
		Airplane.displayInfo();
		
		FlightSimulation Fighter = new Fighter();
		Fighter.setFlight(new SuperSonicFly());
		Fighter.setTakeOff(new LongDistanceTakeOff());
		Fighter.displayInfo();
		
		FlightSimulation Harrier = new Harrier();
		Harrier.setFlight(new SuperSonicFly());
		Harrier.setTakeOff(new VerticalTakeOff());
		Harrier.displayInfo();
	}


}