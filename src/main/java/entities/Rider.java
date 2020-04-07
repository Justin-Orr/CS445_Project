package entities;

public class Rider extends User {
	
	Rating rating; //the rating for now will be out of 5
	
	public Rider(String name, int age) {
		super(name, age, "RIDER");
		rating = new Rating(5);
	}
	
	public Rating getRating() {
		return rating;
	}
	
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	public boolean equals(Rider r) {
		if(super.equals(r) && rating.equals(r.getRating()))
			return true;
		else
			return false;
	}

}
