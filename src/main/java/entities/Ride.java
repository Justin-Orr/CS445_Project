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
	
	private ArrayList<RideRequest> requests;
	
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
		this.requests = new ArrayList<RideRequest>();
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
	
	public String getFromCity() {
		return location_info.getFromCity();
	}
	
	public String getToCity() {
		return location_info.getToCity();
	}
	
	public RideRequest getRideRequest(int jid) {
		for(RideRequest request: requests) {
			if(request.getRequestID() == jid) {
				return request;
			}
		}
		return null;
	}
	
	public void addRider(int riderID, int number_of_passengers) {
		riderIDs.add(riderID);
		spots_available -= number_of_passengers;
	}
	
	public void addRideRequest(RideRequest request) {
		requests.add(request);
	}
	
	public int addMessage(int aid, String msg) {
		return message_history.addMessage(aid, msg);
	}
	
	public void confirmOrDenyRequest(int jid, boolean status) {
		RideRequest request = getRideRequest(jid);
		request.setRideConfirmedStatus(status);
		if(status == true) {
			addRider(request.getRiderID(), request.getNumberOfPassengers());
		}
	}
	
	public void confirmPassengerPickup(int jid) {
		RideRequest request = getRideRequest(jid);
		request.confirmPickup();
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
	

}
