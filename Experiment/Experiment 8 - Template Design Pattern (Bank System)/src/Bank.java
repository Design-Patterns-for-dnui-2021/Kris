public class Bank {
	int queue = 1;
	
	void transaction() {
		getNumber();
		doBusiness();
	}
	
	public void getNumber() {
		System.out.println("Queue number: " + queue + ", Please come into counter number 1");
		queue++;
	}
	
	public void doBusiness() {
		System.out.println("Teller is now handling transaction with customer queue number " + queue);
	}
	
	public void withdrawal(int amt) {
		System.out.println("Withdrawing: " + amt);
	}
	
	public void deposit(int amt) {
		System.out.println("Depositing: " + amt);
	}
	
	public void transfer(int amt, int bankID) {
		System.out.println("Transfering: " + amt + " To: " + bankID);
	}
}
