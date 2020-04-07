package entities;

public class Driver extends User {
	
	Vehicle vehicle;
	Rating rating; //the rating for now will be out of 5
	
	public Driver(String name, int age, Vehicle vehicle) {
		super(name, age, "DRIVER");
		this.vehicle = vehicle;
		this.rating = new Rating(5);
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public Rating getRating() {
		return rating;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	public boolean equals(Driver d) {
		if(super.equals(d) && vehicle.equals(d.getVehicle()) && rating.equals(d.getRating()))
			return true;
		else
			return false;
	}
	
	
}
