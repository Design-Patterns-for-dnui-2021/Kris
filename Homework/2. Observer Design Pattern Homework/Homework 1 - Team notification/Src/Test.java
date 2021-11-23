public class Test {
 
	public static void main(String[] args) {
		Person person1 = new Person("Wian");
		Person person2 = new Person("Mr. Ren");
		
		person1.registerObserver(person1);
		person1.registerObserver(person2);
		
		person1.beat();
	}
	 
}
 
	