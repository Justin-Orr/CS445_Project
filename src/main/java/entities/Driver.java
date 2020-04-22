package entities;

import java.util.Hashtable;

public class Driver extends Account {
	
	private Vehicle vehicle;
	private RideRequest recent_request;
	
	public Driver(String first_name, String last_name, String phone, String picture, boolean is_active) {
		super("DRIVER", first_name, last_name, phone, picture, is_active);
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(int totalSeats, int availableSeats, String make, String model, String color, String plate_state, String plate_serial) {
		this.vehicle = new Vehicle(totalSeats, availableSeats, make, model, color, plate_state, plate_serial);
	}

	public Hashtable<Integer, Rating> viewDriverRating() {
		return super.viewRatings();
	}
	
	public void recieveRideRequest(RideRequest request) {
		this.recent_request = request;
	}
	
	public void confirmPassengerPickup() {
		recent_request.confirmPickup();
	}
	
	public void approveRideRequest(int aid, int rid) {
		recent_request.confirmRequest();
		RideManager.addRider(aid, rid);
	}
	
	public void declineRideRequest() {
		recent_request.denyRequest();
	}
	
	public int createRide(String from_city, String to_city, String date, String time, int max_passengers, double amount_per_passenger, String conditions) {
		return RideManager.createRide(this.getID(), from_city, to_city, date, time, max_passengers, amount_per_passenger, conditions);
	}
	
}
