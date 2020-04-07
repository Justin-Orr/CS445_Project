package entities;

public class Ride {
	
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
	
	public String getPickUpLocation() {
		return pickUp;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getPickUpTime() {
		return pickUptime;
	}
	
	public Driver getDriver() {
		return driver;
	}
	
	public Rider[] getRiders() {
		return riders;
	}
	
	public void setPickUpLocation(String pickUp) {
		this.pickUp = pickUp;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setPickUptime(String pickUptime) {
		this.pickUptime = pickUptime;
	}
	
	public void setDriver(Driver d) {
		this.driver = d;
	}
	
	public void setRiders(Rider[] rider) {
		this.riders = rider;
	}
	
	public boolean equals(Ride r) {
		boolean equal = false;
		if(pickUp.compareTo(r.getPickUpLocation()) == 0 && destination.compareTo(r.getDestination()) == 0 && date.compareTo(r.getDate()) == 0 && pickUptime.compareTo(r.getPickUpTime()) == 0 && driver.equals(r.getDriver())) {
			Rider[] otherRiders = r.getRiders();
			for(int i = 0; i < riders.length; i++) {
				if(riders[i].equals(otherRiders[i]) == false) {
					break;
				}
				equal =  true;
			}
		}
		return equal;
	}

}
