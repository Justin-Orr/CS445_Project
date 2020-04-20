package entities;

import java.util.Hashtable;

public class RideManager {
	
	private static Hashtable<Integer, Ride> list_of_rides = new Hashtable<Integer, Ride>(); //key = rid, value = ride object
	private AccountManager accountManager;
	
	public RideManager() {
		this.accountManager = new AccountManager();
	}
	
	public int createRide(int aid, String from_city, String to_city, String date, String time, int max_passengers, double amount_per_passenger, String conditions) {
		Driver driver = (Driver) accountManager.viewAccountDetails(aid);
		Ride ride = new Ride(from_city, to_city, date, time, driver.getID(), max_passengers, amount_per_passenger, conditions);
		list_of_rides.put(ride.getRideID(), ride);
		return ride.getRideID();
	}
	
	public void updateRide(int rid, int aid, String from_city, String to_city, String date, String time, int max_passengers, double amount_per_passenger, String conditions) {
		if(!driverMatchByID(rid, aid)) {
			//error
		}
		else {
			Ride ride = findRideByID(rid);
			ride.updateRideDetails(from_city, to_city, date, time, max_passengers, amount_per_passenger, conditions); //Think about how rider information gets updated
		}
	}
	
	public void deleteRide() {
		//Do nothing, WARNING: has cascading consequences 
	}
	
	public Hashtable<Integer, Ride> viewAllRides() {
		return list_of_rides;
	}
	
	public Ride viewRideDetail(int rid) {
		return findRideByID(rid);
	}
	
	public void searchRides(String from, String to, String date) {
		//Do nothing from: Chicago to: Elgin date: 20 april 2020
	}
	
	private Ride findRideByID(int rid) {
		return list_of_rides.get(rid);
	}
	
	private boolean driverMatchByID(int rid, int aid) {
		Ride ride = findRideByID(rid);
		Driver driver = (Driver) accountManager.viewAccountDetails(aid);
		return (driver.getID() == ride.getDriverID());
	}

}
