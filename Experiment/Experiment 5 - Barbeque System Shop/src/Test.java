
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chef chef = new Chef();
		Chicken chicken = new Chicken(chef);
		Mutton mutton = new Mutton(chef);
		Customer wian = new Customer(mutton, chicken);
		
		wian.orderChicken();
		wian.orderMmutton();

	}
//	LightOnCommand lightOn = new LightOnCommand(light);
}
