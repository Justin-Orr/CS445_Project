package entities;

public class Rating {
	
	private double rating; //The current rating is a value out of 5
	
	public Rating(double rating) {
		this.rating = rating;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public boolean equals(Rating r) {
		if(rating == r.getRating())
			return true;
		else
			return false;
	}
}
