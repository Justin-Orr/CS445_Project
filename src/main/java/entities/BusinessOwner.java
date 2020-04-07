package entities;

public class BusinessOwner extends User{
	
	private String companyName;
	
	public BusinessOwner(String name, int age, String companyName) {
		super(name, age, "BUSINESSOWNER");
		this.companyName = companyName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public boolean equals(BusinessOwner b) {
		if(super.equals(b) && companyName.compareTo(b.getCompanyName()) == 0) 
			return true;
		else
			return false;
	}

}
