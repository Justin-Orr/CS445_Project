package interfaces;

import java.util.Hashtable;

import entities.Ride;

public interface RideBoundaryInterface {
	
	public int createRide(int aid, String from_city, String to_city, String date, String time, int max_passengers, double amount_per_passenger, String conditions);
	public void updateRide(int rid, int aid, String from_city, String to_city, String date, String time, int max_passengers, double amount_per_passenger, String conditions);
	public void deleteRide();
	public Hashtable<Integer, Ride> viewAllRides();
	public Ride viewRideDetail(int rid);
	public void searchRides(String from, String to, String date);
	public void requestToJoinRide();
	public void confirmOrDenyRequest(boolean action);
	public void confirmPassengerPickup();
	public void addMessageToRide();
	public void viewAllRideMessages();
	
}
