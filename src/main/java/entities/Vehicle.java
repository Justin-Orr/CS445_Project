package entities;

import enums.VehicleType;

public class Vehicle {
	
	private int totalSeats, availableSeats;
	private VehicleType type;
	
	public Vehicle(int total, int available, String type) {
		totalSeats = total;
		availableSeats = available;
		this.type = VehicleType.valueOf(type);
	}

}
