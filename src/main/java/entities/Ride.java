package entities;

public class Ride {
	
	private int rid; //Ride ID
	
	private String pickUp, destination;
	private String date, pickUptime;
	private Driver driver;
	private Rider[] riders;
	
	public Ride(String pickUp, String destination, String date, String pickUptime, Driver driver, Rider[] riders) {
		this.pickUp = pickUp;
		this.destination = destination;
		this.date = date;
		this.pickUptime = pickUptime;
		this.driver = driver;
		this.riders= riders;
	}

}
