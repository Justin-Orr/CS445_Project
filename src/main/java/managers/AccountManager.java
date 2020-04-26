package managers;

import java.util.ArrayList;
import java.util.Hashtable;

import entities.Account;
import entities.BusinessOwner;
import entities.Driver;
import entities.Rating;
import entities.Rider;
import interfaces.AccountBoundaryInterface; 

public class AccountManager implements AccountBoundaryInterface {
	
	private static Hashtable<Integer, Account> list_of_accounts = new Hashtable<Integer, Account>();
	
	public int createAccount(String first_name, String last_name, String phone, String picture, boolean is_active) {
		Account account = new Account(first_name, last_name, phone, picture, is_active);
		addAccount(account);
		return account.getID();
	}
	
	public void activateAccount(int aid, String type, String first_name, String last_name, String phone, String picture, boolean is_active) {
		Account account = getAccount(aid);
		account.activateAccount();
	}
	
	public void updateAccount(int aid, String type, String first_name, String last_name, String phone, String picture, boolean is_active) {
		Account account = getAccount(aid);
		account.updateAccount(first_name, last_name, phone, picture, is_active);
	}
	
	public Hashtable<Integer, Account> viewAllAccounts() {
		return list_of_accounts;
	}
	
	public Hashtable<Integer, Account> searchAccounts() {
		//Do nothing
		return new Hashtable<Integer, Account>();
	}
	
	public int rateAccount(int aid, Rating rating) {
		Account account = getAccount(aid);
		account.addRating(rating);
		return rating.getRatingID();
	}
	
	public ArrayList<Rating> viewDriverRatings(int aid) {
		Driver driver = (Driver) getAccount(aid);
		return driver.viewRatings();
	}
	
	public ArrayList<Rating> viewRiderRatings(int aid) {
		Rider rider = (Rider) getAccount(aid);
		return rider.viewRatings();
	}
	
	public Account getAccount(int aid) {
		return list_of_accounts.get(aid);
	}
	
	private void addAccount(Account account) {
		list_of_accounts.put(account.getID(), account);
	}
	
}
