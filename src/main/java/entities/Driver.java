package entities;

public class Driver extends User {
	
	Vehicle vehicle;
	Rating rating;
	
	public Driver(String name, int age, Vehicle vehicle) {
		super(name, age, "DRIVER");
		this.vehicle = vehicle;
		this.rating = new Rating(0);
	}
	
}
