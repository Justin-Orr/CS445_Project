package entities;

public class Rider extends Account { 
		
	public Rider(String first_name, String last_name, String phone, String picture, boolean is_active) {
		super("RIDER", first_name, last_name, phone, picture, is_active);
	}

}
