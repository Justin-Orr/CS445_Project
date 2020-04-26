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
		this.riderIDs = new ArrayList<Integer>();
		this.message_history = new History();
		
	}
	
	public int getRideID() {
		return rid;
	}
	
	public void addRider(int riderID) {
		this.riderID = riderID;
	}
	
	public int getComplementID(int sent_by_id) {
		//If argument is a rider id then grab driver id and vice versa
		if(driverID == sent_by_id) {
			return riderID;
		}
		else {
			return driverID;
		}
	}

	public String getDate() {
		return date;
	}

	public int getDriverID() {
		return driverID;
	}
	
	public History getMessageHistory() {
		return this.message_history;
	}

	public void updateRideDetails(String pickUp, String destination, String date, String pickUptime, int max_passengers, double amount_per_passenger, String conditions) {
		this.pickUp = pickUp;
		this.destination = destination;
		this.date = date;
		this.time = pickUptime;
		this.max_passengers = max_passengers;
		this.amount_per_passenger = amount_per_passenger;
		this.conditions = conditions;
	}
	
	public int addMessage(int aid, String msg) {
		return message_history.addMessage(aid, msg);
	}
	
	public String toString() {
		String str = "[rid: " + rid +
					"; pickUp: " + pickUp +
					"; destination: " + destination +
					"; date: " + date +
					"; pickUptime: " + time +
					"; driverID: " + driverID +
					"; riderID: " + riderID +
					"; max_passengers: " + max_passengers +
					"; amount_per_passenger: " + amount_per_passenger +
					"; conditions: " + conditions +
					"]";
		return str;
	}

}
