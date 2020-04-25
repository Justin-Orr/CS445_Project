package entities;

import java.util.Hashtable;

import interfaces.RideRequestBoundaryInterface;

public class RideRequestManager implements RideRequestBoundaryInterface{
	
	private static Hashtable<Integer, RideRequest> list_of_requests = new Hashtable<Integer, RideRequest>();
	
	public int requestToJoinRide(int rid, int aid, int passengers, Boolean ride_confirmed, Boolean pickup_confirmed) {
		int jid = createRideRequest(rid, aid, passengers, ride_confirmed, pickup_confirmed);
		return jid;
	}
	
	private int createRideRequest(int rid, int aid, int passengers, Boolean ride_confirmed, Boolean pickup_confirmed) {
		RideRequest request = new RideRequest(aid, passengers, ride_confirmed, pickup_confirmed);
		int requestID = request.getRequestID();
		list_of_requests.put(requestID, request);
		return requestID;
	}
	
	private RideRequest findRideRequestByID(int aid) {
		//Do nothing
		return null;
	}
	
	public void confirmRequest(int aid) {
		//Do nothing
	}
	public void denyRequest(int aid) {
		//Do nothing
	}
	public void confirmPassengerPickup(int aid) {
		//Do nothing
	}

	public RideRequest viewRideRequestDetails(int jid) {
		return list_of_requests.get(jid);
	}

}
