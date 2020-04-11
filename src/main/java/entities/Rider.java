package entities;

public class Rider extends User {
	
	Rating rating; 
	
	public Rider(String name, int age) {
		super(name, age, "RIDER");
		rating = new Rating(5);
	}

}
