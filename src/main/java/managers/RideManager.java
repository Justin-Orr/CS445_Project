package managers;

import java.util.ArrayList;
import java.util.Hashtable;

import entities.Driver;
import entities.LocationDetails;
import entities.Message;
import entities.Ride;
import entities.Rider;
import entities.Vehicle;
import interfaces.RideBoundaryInterface;

public class RideManager implements RideBoundaryInterface{
	
	private static Hashtable<Integer, Ride> list_of_rides = new Hashtable<Integer, Ride>(); //key = rid, value = ride object
	
	public int createRide(int driverID, LocationDetails location_info, String date, String time, Vehicle vehicle, int max_passengers, double amount_per_passenger, String conditions) {
		Ride ride = new Ride(driverID, location_info, date, time, vehicle, max_passengers, amount_per_passenger, conditions);
		list_of_rides.put(ride.getRideID(), ride);
		return ride.getRideID();
	}
	
	public void updateRide(int rid, LocationDetails location_info, String date, String time, Vehicle vehicle, int max_passengers, double amount_per_passenger, String conditions) {
		Ride ride = findRideByRideID(rid);
		ride.updateRideDetails(location_info, date, time, vehicle, max_passengers, amount_per_passenger, conditions);
	}
	
	public void deleteRide(int rid) {
		list_of_rides.remove(rid);
	}
	
	public Hashtable<Integer, Ride> viewAllRides() {
		return list_of_rides;
	}
	
	public Ride viewRideDetail(int rid) {
		return findRideByRideID(rid);
	}
	
	public void searchRides(String from, String to, String date) {
		//Do nothing from: Chicago to: Elgin date: 20 april 2020
	}
	
	public void requestToJoinRide(int rid, int aid) {
		//Do nothing
	}
	
	public void confirmOrDenyRequest(boolean action) {
		//Do nothing
	}
	
	public void confirmPassengerPickup() {
		//Do nothing
	}
	
	public int addMessageToRide(int aid, String msg) {
		Ride ride = findRideByAccountID(aid);
		return ride.addMessage(aid, msg);
	}
	
	public ArrayList<Message> viewAllRideMessages(int rid) {
		Ride ride = findRideByRideID(rid);
		return ride.getMessageHistory().viewMessageHistory();
	}
	
	public void addRider(int rid, int aid, int number_of_passengers) {
		Ride ride = findRideByRideID(rid);
		ride.addRider(aid, number_of_passengers);
	}
	
	public boolean isValidRideID(int rid) {
		return list_of_rides.containsKey(rid);
	}
	
	private Ride findRideByRideID(int rid) {
		return list_of_rides.get(rid);
	}
	
	private Ride findRideByAccountID(int aid) {
		for(Ride ride: list_of_rides.values()) {
			if(ride.containsAccount(aid)) {
				return ride;
			}
		}
		return null;
	}

}
