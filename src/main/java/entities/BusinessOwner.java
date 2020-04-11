package entities;

public class BusinessOwner extends User {
	
	private String companyName;
	
	public BusinessOwner(String name, int age, String companyName) {
		super(name, age, "BUSINESSOWNER");
		this.companyName = companyName;
	}

}
