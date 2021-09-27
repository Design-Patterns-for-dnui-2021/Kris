package experiment02;

public class Test {

	public static void main(String[] args) {
		Stock s001 = new StockA("001",100);
		StakeHolder tom = new ShareHolder("231021198302138231","Tom");
		
		s001.registerShareHolder(tom);

		s001.setPrice(94);
	}

}
