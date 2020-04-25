package interfaces;

import java.util.Hashtable;
import entities.Account;

public interface AccountBoundaryInterface {
	
	public int createAccount(String type, String first_name, String last_name, String phone, String picture, boolean is_active);
	public void activateAccount(int aid, String type, String first_name, String last_name, String phone, String picture, boolean is_active);
	public void updateAccount(int aid, String type, String first_name, String last_name, String phone, String picture, boolean is_active);
	public void deleteAccount(int aid);
	public Hashtable<Integer, Account> viewAllAccounts();
	public Account viewAccountDetails(int aid);
	public Hashtable<Integer, Account> searchAccounts();

}
