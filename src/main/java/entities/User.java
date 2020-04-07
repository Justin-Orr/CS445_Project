package entities;

public class User extends Person {
	
	private Account account; 
	
	public User(String name, int age, String type) {
		super(name, age);
		account = new Account(type);
	}
	
	public Account getAccount() {
		return account;
	}
	
	public boolean equals(User u) {
		if(super.equals(u) && account.equals(u.getAccount()))
			return true;
		else
			return false;
	}

}
