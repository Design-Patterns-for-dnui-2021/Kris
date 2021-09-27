import java.util.Scanner;

public class Simulation {
 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i = 0;
		String sound;
		PetFactory factory = new PetFactory();
		
		while (i < 5){
			System.out.println("Insert sound: ");
			sound = input.nextLine();
			Pet pet = factory.createBy(sound);
			pet.displayInfo();
			i++;
		}
	}
	 
}
 
