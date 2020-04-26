package interfaces;

import java.util.ArrayList;
import java.util.Hashtable;
import entities.Account;
import entities.Rating;

public interface AccountBoundaryInterface {
	
	public int createAccount(String first_name, String last_name, String phone, String picture, boolean is_active);
	public void activateAccount(int aid, String type, String first_name, String last_name, String phone, String picture, boolean is_active);
	public void updateAccount(int aid, String type, String first_name, String last_name, String phone, String picture, boolean is_active);
	public Hashtable<Integer, Account> viewAllAccounts();
	public Hashtable<Integer, Account> searchAccounts();
	public int rateAccount(int aid, Rating rating);
	public ArrayList<Rating> viewDriverRatings(int aid);
	public ArrayList<Rating> viewRiderRatings(int aid);

}
