package entities;

import java.util.Hashtable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Account {
	
	@JsonProperty("aid")
	private int aid; //Account ID
	
	@JsonProperty("first_name")
	private String first_name;
	
	@JsonProperty("last_name")
	private String last_name;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("picture")
	private String picture;
	
	@JsonProperty("is_active")
	private boolean is_active;
	
	private String date_created;
	
	private int rides; //number of rides
	private int ratings; //number of ratings
	private double average_rating;
	private Hashtable<Integer, Rating> list_of_ratings;
	
	private Ride active_ride;
	
	public Account(String first_name, String last_name, String phone, String picture, boolean is_active) {
        this.aid = UniqueIdGenerator.getUniqueID();
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.picture = picture;
        this.is_active = is_active;
        
        this.rides = 0;
        this.ratings = 0;
        this.average_rating = 0;
        this.list_of_ratings = new Hashtable<Integer, Rating>();
        
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy, HH:mm:ss");
        this.date_created = dtf.format(dateTime);
	}
	
	public int getID() {
		return aid;
	}
	
	public void activateAccount() {
		this.is_active = true;
	}
	
	public void updateAccount(String first_name, String last_name, String phone, String picture, boolean is_active) {
		this.first_name = first_name;
	    this.last_name = last_name;
	    this.phone = phone;
	    this.picture = picture;
	    this.is_active = is_active;
	}
	
	public void addRating(Rating rating) {
		int rater = rating.getReviewer();
		ratings++;
		list_of_ratings.put(rater, rating);
		updateAverageRating();
	}
	
	public void incrementNumberOfRides() {
		rides++;
	}
	
	public Hashtable<Integer, Rating> viewRatings() {
		return list_of_ratings;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public int addMessage(String msg) {
		return active_ride.addMessage(aid, msg);
	}
	
	public void setActiveRide(Ride ride) {
		this.active_ride = ride;
	}
	
	public String toString() {
		String str = "{aid: " + aid +
					"; date_created: " + date_created +
					"; first_name: " + first_name +
					"; last_name: " + last_name +
					"; phone: " + phone +
					"; picture: " + picture +
					"; is_active: " + is_active +
					"; rides: " + rides +
					"; ratings: " + ratings +
					"; average_rating: " + average_rating +
					"}";
		return str;
	} 
	
	private void updateAverageRating() {
		int sum = 0;
		for(Rating r: list_of_ratings.values()) {
			sum += r.getRating();
		}
		average_rating = sum/ratings;
	}
	
}