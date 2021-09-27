package experiment02;

import java.util.ArrayList;

public abstract class Stock {
 
	private String sno;
	 
	private double price;
	 
	private ArrayList<StakeHolder> shareHolders;
	
	 
	public Stock(String sno,double price) {
		this.sno = sno;
		this.price = price;
		shareHolders = new ArrayList<StakeHolder>();		
	}

	public void registerShareHolder(StakeHolder shareHolder) {
		shareHolders.add(shareHolder);
	}
	 
	public void removeShareHolder(StakeHolder shareHolder) {
		shareHolders.remove(shareHolder);
	}
	 
	public void notifyShareHolders() {
		for(StakeHolder shareHolder:shareHolders){
			shareHolder.update(sno,price);
		}
	}

	public void setPrice(double price) {
		double oldPrice = this.price;
		this.price = price;		
		if(Math.abs((price-oldPrice)/oldPrice) > 0.05){
			this.notifyShareHolders();
		}
		
	}	 
}
 
