package entities;

import util.UniqueIdGenerator;

public class RideRequest {
	
	private int jid; //join ride request ID
	private int aid;
	private int passengers; //The number of passengers
	private Boolean ride_confirmed;
	private Boolean pickup_confirmed;
	
	public RideRequest(int aid, int passengers, Boolean ride_confirmed, Boolean pickup_confirmed) {
		this.jid = UniqueIdGenerator.getUniqueID();
		this.aid = aid;
		this.passengers = passengers;
		this.ride_confirmed = ride_confirmed;
		this.pickup_confirmed = pickup_confirmed;
	}

	public int getRequestID() {
		return jid;
	}
	
	public void confirmRequest() {
		ride_confirmed = true;
	}
	
	public void denyRequest() {
		ride_confirmed = false;
	}
	
	public void confirmPickup() {
		pickup_confirmed = true;
	}
	
	public String toString() {
		String str = "[jid: " + jid +
				"; aid: " + aid +
				"; passengers: " + passengers + 
				"; ride_confirmed: " + ride_confirmed +
				"; pickup_confirmed: " + pickup_confirmed +
				"]";
		return str;
	}

}
