package entities;

import java.util.Hashtable;
import interfaces.RatingBoundaryInterface;
import managers.AccountManager;

public class RatingManager implements RatingBoundaryInterface {
	
	private static AccountManager account_manager = new AccountManager();
	private static RideManager ride_manager = new RideManager();
	
	public int rateAccount(int rid, int sent_by_id, int rating, String comment) {
		if(ratingValidator(rating) == -1) {
			return -1;
		}
		else {
			Ride ride = ride_manager.viewRideDetail(sent_by_id);
			int complementary_id = ride.getComplementID(sent_by_id); //Assuming one rider with multiple passengers for now
			Account account = account_manager.viewAccountDetails(complementary_id);
			Rating rate = new Rating(rid, sent_by_id, account.getFirstName(), ride.getDate(), rating, comment);
			account.addRating(rate);
			return rate.getRatingID();
		}
	}
	
	public Hashtable<Integer, Rating> viewDriverRatings(int aid) {
		Driver driver = (Driver) account_manager.viewAccountDetails(aid);
		return driver.viewRatings();
	}
	
	public Hashtable<Integer, Rating> viewRiderRatings(int aid) {
		Rider rider = (Rider) account_manager.viewAccountDetails(aid);
		return rider.viewRatings();
	}
	
	private int ratingValidator(int rating) {
		if(rating > 5 || rating < 1)
			return -1;
		else
			return rating;
	}
	
}
