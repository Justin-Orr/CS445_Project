package entities;

public class LocationDetails {

	private String from_city;
	private String to_city;
	private String from_zip;
	private String to_zip;
	
	public LocationDetails(String from_city, String to_city, String from_zip, String to_zip) {
		this.setFromCity(from_city);
		this.setToCity(to_city);
		this.setFromZip(from_zip);
		this.setToZip(to_zip);
	}

	public String getFromCity() {
		return from_city;
	}
	
	public String getToCity() {
		return to_city;
	}
	
	public String getFromZip() {
		return from_zip;
	}
	
	public String getToZip() {
		return to_zip;
	}

	public void setFromCity(String from_city) {
		this.from_city = from_city;
	}

	public void setToCity(String to_city) {
		this.to_city = to_city;
	}

	public void setFromZip(String from_zip) {
		this.from_zip = from_zip;
	}

	public void setToZip(String to_zip) {
		this.to_zip = to_zip;
	}
	
}
