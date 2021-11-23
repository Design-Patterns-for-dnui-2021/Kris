public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		TVFactory factory = new TVFactory();
		
		TV haier = factory.produceTV("haier");
		haier.play();
		System.out.println();
		TV hisense = factory.produceTV("hisense");
		hisense.play();
		
	}

}
