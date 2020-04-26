package entities;

import java.util.ArrayList;

import util.UniqueIdGenerator;

public class Ride {
	
	private int rid; //Ride ID
	
	private LocationDetails location_info;
	private String date;
	private String time;
	private Vehicle vehicle;
	
	private int max_passengers;
	private double amount_per_passenger;
	private String conditions;
	private int spots_available;

	private int driverID;
	private ArrayList<Integer> riderIDs;
	private History message_history;
	
	public Ride(int driverID, LocationDetails location_info, String date, String time, Vehicle vehicle, int max_passengers, double amount_per_passenger, String conditions) {
		this.rid = UniqueIdGenerator.getUniqueID();
		
		this.location_info = location_info;
		this.date = date;
		this.time = time;
		this.vehicle = vehicle;
		
		this.max_passengers = max_passengers;
		this.amount_per_passenger = amount_per_passenger;
		this.conditions = conditions;
		this.spots_available = max_passengers;
		
		this.driverID = driverID;
		this.riderIDs = new ArrayList<Integer>();
		this.message_history = new History();
	}
	
	public int getRideID() {
		return rid;
	}

	public String getDate() {
		return date;
	}
	
	public History getMessageHistory() {
		return message_history;
	}
	
	public int getSpotsAvailable() {
		return spots_available;
	}
	
//	public int getComplementID(int sent_by_id) {
//		//If argument is a rider id then grab driver id and vice versa
//		if(driverID == sent_by_id) {
//			return riderID;
//		}
//		else {
//			return driverID;
//		}
//	}
	
	public void addRider(int riderID, int number_of_passengers) {
		riderIDs.add(riderID);
		spots_available -= number_of_passengers;
	}

	public void updateRideDetails(LocationDetails location_info, String date, String time, Vehicle vehicle, int max_passengers, double amount_per_passenger, String conditions) {
		//Validate the id in the rest controller
		this.location_info = location_info;
		this.date = date;
		this.time = time;
		this.vehicle = vehicle;
		this.max_passengers = max_passengers;
		this.amount_per_passenger = amount_per_passenger;
		this.conditions = conditions;
	}
	
	public boolean containsAccount(int aid) {
		if(aid == driverID) {
			return true;
		}
		
		for(int id: riderIDs) {
			if(aid == id) {
				return true;
			}
		}
		
		return false;
	}
	
	public int addMessage(int aid, String msg) {
		return message_history.addMessage(aid, msg);
	}
	
//	public String toString() {
//		String str = "[rid: " + rid +
//					"; pickUp: " + pickUp +
//					"; destination: " + destination +
//					"; date: " + date +
//					"; pickUptime: " + time +
//					"; driverID: " + driverID +
//					"; riderID: " + riderID +
//					"; max_passengers: " + max_passengers +
//					"; amount_per_passenger: " + amount_per_passenger +
//					"; conditions: " + conditions +
//					"]";
//		return str;
//	}

}
