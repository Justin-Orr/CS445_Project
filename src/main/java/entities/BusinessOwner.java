package entities;

public class BusinessOwner extends Account {
	
	private String companyName;
	
	public BusinessOwner(String first_name, String last_name, String phone, String picture, boolean is_active) {
		super(first_name, last_name, phone, picture, is_active);
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
