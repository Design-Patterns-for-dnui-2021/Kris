public class CreateUserLevel1 implements CreateUser {
 
	public User createUser() {
		System.out.println("A new User level 1 has been created");
		System.out.println("Level 1 access is granted");
		System.out.println("");
		return new UserLevel1();
	}
	 
}
 
