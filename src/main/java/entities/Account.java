package entities;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

import util.UniqueIdGenerator;
import util.TimeDateFormatter;


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
	private ArrayList<Rating> list_of_ratings;
		
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
        this.list_of_ratings = new ArrayList<Rating>();
        
        this.date_created = TimeDateFormatter.timeStamp();
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
	
	public String getFirstName() {
		return first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public String getPhoneNumber() {
		return phone;
	}
	
	public ArrayList<Rating> viewRatings() {
		return list_of_ratings;
	}
	
	public void addRating(Rating rating) {
		ratings++;
		list_of_ratings.add(rating);
		updateAverageRating();
	}
	
	public void incrementNumberOfRides() {
		rides++;
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
		for(Rating r: list_of_ratings) {
			sum += r.getRating();
		}
		average_rating = sum/ratings;
	}
	
}