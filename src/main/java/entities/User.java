package entities;

public class User extends Person {
	
	private Account account; 
	
	public User(String name, int age, String type) {
		super(name, age);
		account = new Account(type);
	}

}
