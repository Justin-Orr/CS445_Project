package entities;

public class RideRequest {
	
	private int jid; //join ride request ID
	private int aid;
	private int passengers; //The number of passengers
	private boolean ride_confirmed;
	private boolean pickup_confirmed;
	
	public RideRequest(int aid, int passengers, boolean ride_confirmed, boolean pickup_confirmed) {
		this.jid = UniqueIdGenerator.getUniqueID();
		this.aid = aid;
		this.passengers = passengers;
		this.ride_confirmed = ride_confirmed;
		this.pickup_confirmed = pickup_confirmed;
	}

	public int getRequestID() {
		return jid;
	}

}
