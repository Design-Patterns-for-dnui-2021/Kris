public class PetFactory {
 
	private String sound;
	
	public Pet createBy(String sound) {
		this.sound = sound;
		if(sound.equalsIgnoreCase("quack")){
			return new Duck();
		}
		if(sound.equalsIgnoreCase("meow")){
			return new Cat();
		}
		if(sound.equalsIgnoreCase("bark")){
			return new Dog();
		}
		if(sound.equalsIgnoreCase("chirp")){
			return new Bird();
		}
		throw new Error("Invalid Sound!");
	}
	public void displayInfo() {
		
	}
}
 
