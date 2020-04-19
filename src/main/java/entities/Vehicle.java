package entities;

public class Vehicle {
	
	private int totalSeats, availableSeats;
	private String make, model, color;
	private String plate_state;
	private String plate_serial;
	
	public Vehicle(int totalSeats, int availableSeats, String make, String model, String color, String plate_state, String plate_serial) {
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.make = make;
		this.model = model;
		this.color = color;
		this.plate_state = plate_state;
		this.plate_serial = plate_serial;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}

}
