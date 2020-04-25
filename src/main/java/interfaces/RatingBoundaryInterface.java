package interfaces;

import java.util.Hashtable;

import entities.Rating;

public interface RatingBoundaryInterface {
	
	public int rateAccount(int rid, int sent_by_id, int rating, String comment);
	public Hashtable<Integer, Rating> viewDriverRatings(int aid);
	public Hashtable<Integer, Rating> viewRiderRatings(int aid);
	
}
