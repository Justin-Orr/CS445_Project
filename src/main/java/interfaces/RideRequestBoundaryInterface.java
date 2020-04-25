package interfaces;

public interface RideRequestBoundaryInterface {

	public int requestToJoinRide(int rid, int aid, int passengers, Boolean ride_confirmed, Boolean pickup_confirmed);
	public void confirmRequest(int aid);
	public void denyRequest(int aid);
	public void confirmPassengerPickup(int aid);
	
}
