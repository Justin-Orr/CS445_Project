package entities;

import java.util.Hashtable;

public class Rider extends Account { 
		
	public Rider(String first_name, String last_name, String phone, String picture, boolean is_active) {
		super("RIDER", first_name, last_name, phone, picture, is_active);
	}
	
	public Hashtable<Integer, Rating> viewRiderRating() {
		return super.viewRatings();
	}
	
	public int issueRideRequest(int rid, int passengers) {
		Boolean ride_confirmed = null; 
		Boolean pickup_confirmed = null;
		return RideRequestManager.requestToJoinRide(rid, this.getID(), passengers, ride_confirmed, pickup_confirmed);
	}

}
