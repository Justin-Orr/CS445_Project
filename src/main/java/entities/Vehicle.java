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
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	
	public int getTotalSeats() {
		return totalSeats;
	}
	
	public String getVehicleType() {
		return type.toString();
	}
	
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	public void setVehicleType(String type) {
		this.type = VehicleType.valueOf(type);
	}
	
	public boolean equals(Vehicle v) {
		if(totalSeats == v.getTotalSeats() && availableSeats == v.getAvailableSeats() && type == VehicleType.valueOf(v.getVehicleType()))
			return true;
		else
			return false;
	}
}
