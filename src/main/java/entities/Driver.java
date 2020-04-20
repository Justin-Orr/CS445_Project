package entities;

import java.util.Hashtable;

public class Driver extends Account {
	
	private Vehicle vehicle;
	private RideRequest active_request;
	
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
		this.active_request = request;
	}
	
	public void confirmPassengerPickup() {
		active_request.confirmPickup();
	}
	
	public void approveRideRequest() {
		active_request.confirmRequest();
	}
	
	public void declineRideRequest() {
		active_request.denyRequest();
	}
	
	public void addMessage(int rid, String msg) {
		//do nothing
	}
	
}
