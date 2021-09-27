public class TVFactory {
	private String tvName;
	
	public TV produceTV(String tvName) {
		this.tvName = tvName;
		if(tvName.equalsIgnoreCase("haier")) {
			System.out.println("Producing Haier TV");
			return new HaierTV();
		}
		if(tvName.equalsIgnoreCase("hisense")) {
			System.out.println("Producing Hisense TV");
			return new HisenseTV();
		}
		throw new Error("Invalid");
	}
}
 
