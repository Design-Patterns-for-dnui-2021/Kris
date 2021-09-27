package experiment02;

public class ShareHolder implements StakeHolder{
 
	private String id;	 
	private String name;
	 
	public ShareHolder(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public void update(String sno,double price) {
		System.out.println(name + " have known that stock:["+sno+"]'s price has changed into "+price);
	}
	 
}
 
