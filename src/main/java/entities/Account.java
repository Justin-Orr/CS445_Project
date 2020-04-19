package entities;

import enums.AccountType;
import java.util.Hashtable;

public class Account {
	
	private int aid; //Account ID
	private AccountType type;
	
	private String first_name, last_name;
	private String phone;
	private String picture;
	private boolean is_active;
	
	private int rides; //number of rides
	private int ratings; //number of ratings
	private double average_rating;
	
	private Hashtable<Integer, Rating> list_of_ratings;
	
	public Account(String type, String first_name, String last_name, String phone, String picture, boolean is_active) {
        this.aid = UniqueIdGenerator.getUniqueID();
        this.type = AccountType.valueOf(type);
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.picture = picture;
        this.is_active = is_active;
        this.list_of_ratings = new Hashtable<Integer, Rating>();
	}
	
	public boolean matchesId(int id) {
        return(id == this.aid);
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
		int rater = rating.getRater();
		list_of_ratings.put(rater, rating);
	}
	
	public Hashtable<Integer, Rating> viewRatings() {
		return list_of_ratings;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	private void findRatingByID(int sid) {
		//Do nothing
	}
	
}