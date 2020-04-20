package entities;

import java.util.Hashtable;

public class AccountManager {
	
	private static Hashtable<Integer, Account> list_of_accounts = new Hashtable<Integer, Account>();
	
	public int createAccount(String type, String first_name, String last_name, String phone, String picture, boolean is_active) {
		if(type.compareTo("DRIVER") == 0) {
			return createDriver(first_name, last_name, phone, picture, is_active);			
		}
		else if(type.compareTo("RIDER") == 0) {
			return createRider(first_name, last_name, phone, picture, is_active);
		}
		else if(type.compareTo("BUSINESSOWNER") == 0) {
			return createBusinessOwner(first_name, last_name, phone, picture, is_active);
		}
		else {
			return -1;
		}	
	}
	
	private int createDriver(String first_name, String last_name, String phone, String picture, boolean is_active) {
		Driver driver = new Driver(first_name, last_name, phone, picture, is_active);
		addAccount(driver);
		return driver.getID();
	}
	
	private int createRider(String first_name, String last_name, String phone, String picture, boolean is_active) {
		Rider rider = new Rider(first_name, last_name, phone, picture, is_active);
		addAccount(rider);
		return rider.getID();
	}
	
	private int createBusinessOwner(String first_name, String last_name, String phone, String picture, boolean is_active) {
		BusinessOwner owner = new BusinessOwner(first_name, last_name, phone, picture, is_active);
		addAccount(owner);
		return owner.getID();
	}
	
	public void addAccount(Account account) {
		list_of_accounts.put(account.getID(), account);
	}
	
	public void deleteAccount() {
		//Do nothing. WARNING: This has a cascading affect across multiple entities referencing the account
	}
	
	public void updateAccount(int aid, String type, String first_name, String last_name, String phone, String picture, boolean is_active) {
		Account account = findAccountByID(aid);
		account.updateAccount(first_name, last_name, phone, picture, is_active);
	}
	
	public void activateAccount(int aid, String type, String first_name, String last_name, String phone, String picture, boolean is_active) {
		Account account = findAccountByID(aid);
		account.activateAccount();
	}
	
	public Hashtable<Integer, Account> viewAllAccounts() {
		return list_of_accounts;
	}
	
	public Account viewAccountDetails(int aid) {
		return findAccountByID(aid);
	}
	
	public Hashtable<Integer, Account> searchAccounts() {
		return new Hashtable<Integer, Account>();
	}
	
	private Account findAccountByID(int aid) {
		return list_of_accounts.get(aid);
	}
	
	private void findAccountByKeyword() {
		//Do nothing
	}
	
}
