package entities;

import java.util.Hashtable;

public class RideRequestManager {
	
	private static Hashtable<Integer, RideRequest> list_of_requests = new Hashtable<Integer, RideRequest>();
	private static RideManager ride_manager;
	private static AccountManager account_manager;
	
	public RideRequestManager() {
		account_manager = new AccountManager();
		ride_manager = new RideManager();
	}
	
	public RideRequest viewRideRequestDetails(int jid) {
		return findRideRequestByID(jid);
	}
	
	public static int requestToJoinRide(int rid, int aid, int passengers, boolean ride_confirmed, boolean pickup_confirmed) {
		int jid = createRideRequest(rid, aid, passengers, ride_confirmed, pickup_confirmed);
		return jid;
	}
	
	private static void issueRequestToDriver(int aid, RideRequest request) {
		Driver driver = (Driver) account_manager.viewAccountDetails(aid);
		driver.recieveRideRequest(request);
	}
	
	private static int createRideRequest(int rid, int aid, int passengers, boolean ride_confirmed, boolean pickup_confirmed) {
		RideRequest request = new RideRequest(aid, passengers, ride_confirmed, pickup_confirmed);
		Ride ride = ride_manager.viewRideDetail(rid);
		issueRequestToDriver(ride.getDriverID(), request);
		int requestID = request.getRequestID();
		list_of_requests.put(requestID, request);
		return requestID;
	}
	
	private RideRequest findRideRequestByID(int jid) {
		return list_of_requests.get(jid);
	}

}
