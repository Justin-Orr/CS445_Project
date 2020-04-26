package managers;

import java.util.ArrayList;
import java.util.Hashtable;

import entities.Account;
import entities.Driver;
import entities.LocationDetails;
import entities.Message;
import entities.Ride;
import entities.RideRequest;
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
	
	public ArrayList<Ride> searchRides(String from, String to, String date) {
		ArrayList<Ride> valid_rides;
		//The search is case insensitive
		String from_city = from.toLowerCase();
		String to_city = to.toLowerCase();
		
		if(from_city.compareTo("") == 0 || to_city.compareTo("") == 0 || date.compareTo("") == 0) {
			valid_rides = new ArrayList<Ride>(list_of_rides.values());
		}
		else {
			
			valid_rides = new ArrayList<Ride>();
			
			for(Ride ride: list_of_rides.values()) {
				
				String fc = ride.getFromCity().toLowerCase();
				String tc = ride.getToCity().toLowerCase();
				if(fc.compareTo(from_city) == 0 && tc.compareTo(to_city) == 0 && ride.getDate().compareTo(date) == 0) {
					valid_rides.add(ride);
				}
				
			}
			
		}
		
		return valid_rides;
	}
	
	public int requestToJoinRide(int rid, int aid, int passengers) {
		RideRequest request = new RideRequest(aid, passengers, null, null);
		Ride ride = findRideByRideID(rid);
		ride.addRideRequest(request);
		return request.getRequestID();
	}
	
	public void confirmOrDenyRequest(int rid, int jid, boolean ride_confirmed) {
		Ride ride = findRideByRideID(rid);
		ride.confirmOrDenyRequest(jid, ride_confirmed);
	}
	
	public void confirmPassengerPickup(int rid, int jid) {
		Ride ride = findRideByRideID(rid);
		ride.confirmPassengerPickup(jid);
	}
	
	public int addMessageToRide(int aid, String msg) {
		Ride ride = findRideByAccountID(aid);
		return ride.addMessage(aid, msg);
	}
	
	public ArrayList<Message> viewAllRideMessages(int rid) {
		Ride ride = findRideByRideID(rid);
		return ride.getMessageHistory().viewMessageHistory();
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
