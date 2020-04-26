package interfaces;

import java.util.ArrayList;
import java.util.Hashtable;

import entities.LocationDetails;
import entities.Message;
import entities.Ride;
import entities.Vehicle;

public interface RideBoundaryInterface {
	
	public int createRide(int driverID, LocationDetails location_info, String date, String time, Vehicle vehicle, int max_passengers, double amount_per_passenger, String conditions);
	public void updateRide(int rid, LocationDetails location_info, String date, String time, Vehicle vehicle, int max_passengers, double amount_per_passenger, String conditions);
	public void deleteRide(int rid);
	public Hashtable<Integer, Ride> viewAllRides();
	public Ride viewRideDetail(int rid);
	public void searchRides(String from, String to, String date);
	public void requestToJoinRide();
	public void confirmOrDenyRequest(boolean action);
	public void confirmPassengerPickup();
	public int addMessageToRide(int aid, String msg);
	public ArrayList<Message> viewAllRideMessages(int rid);
	
}
