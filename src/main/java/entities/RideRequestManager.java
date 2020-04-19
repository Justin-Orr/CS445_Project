package entities;

import java.util.Hashtable;

public class RideRequestManager {
	
	private static Hashtable<Integer, RideRequest> list_of_requests = new Hashtable<Integer, RideRequest>();
	private AccountManager account_manager;
	
	public RideRequestManager(AccountManager account_manager) {
		this.account_manager = account_manager;
	}
	
	public RideRequest viewRideRequestDetails(int jid) {
		return findRideRequestByID(jid);
	}
	
	private RideRequest findRideRequestByID(int jid) {
		return list_of_requests.get(jid);
	}

}
