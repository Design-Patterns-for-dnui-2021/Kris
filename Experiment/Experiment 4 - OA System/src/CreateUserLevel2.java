public class CreateUserLevel2 implements CreateUser {
 
	public User createUser() {
		System.out.println("A new User level 2 has been created");
		System.out.println("Level 2 access is granted");
		System.out.println("");
		return new UserLevel2();
	}
	 
}
 
