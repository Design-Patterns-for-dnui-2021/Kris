import java.util.Scanner;

public class Teller extends Bank {
	Scanner read = new Scanner(System.in);
	int amt = 0, bankID = 0;
	final void transaction() {
		getNumber();
		doBusiness();
	}
	
	public void doBusiness() {
		int answer;
		System.out.println("Please choose a transaction: ");
		System.out.println("1. Withdrawal");
		System.out.println("2. Deposit");
		System.out.println("3. Transfer");
		System.out.print("Input number: ");
		answer = read.nextInt();
		switch(answer) {
		case 1:
			System.out.print("Please input amount to be withdrawed: ");
			amt = read.nextInt();
			withdrawal(amt);
			break;
		case 2:
			System.out.print("Please input amount to be deposied: ");
			amt = read.nextInt();
			deposit(amt);
			break;
		case 3:
			System.out.print("Please input amount to be transfered: ");
			amt = read.nextInt();
			System.out.print("Please bank ID target: ");
			bankID = read.nextInt();
			transfer(amt,bankID);
			break;
		}
	}
}
