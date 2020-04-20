package CS445_Project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.*;

import entities.*;

@TestMethodOrder(OrderAnnotation.class)
class AppTest {
	
	//The @TestMethodOrder and @Order notations go hand in hand to ensure methods are tested in a specified order
	AccountManager account_manager;
	
	//Account Use Cases
	@BeforeEach public void initialize() {
		account_manager = new AccountManager();
	}
	
    @Test @Order(1) void testCreateAccount() {
    	int driverID = account_manager.createAccount("DRIVER", "John", "Doe", "123-456-7890", "C:/Photo.jpg", false);
    	int riderID = account_manager.createAccount("RIDER", "Jake", "Long", "123-456-7890", "C:/Photo.jpg", false);
    	int ownerID = account_manager.createAccount("BUSINESSOWNER", "Bob", "Hill", "123-456-7890", "C:/Photo.jpg", false);
        
    	boolean initialized = false;
    	Account a = account_manager.viewAccountDetails(driverID);
    	Account b = account_manager.viewAccountDetails(riderID);
    	Account c = account_manager.viewAccountDetails(ownerID);
    	
    	String s = "[aid: 1; type: DRIVER; first_name: John; last_name: Doe; phone: 123-456-7890; picture: C:/Photo.jpg; is_active: false; rides: 0; ratings: 0; average_rating: 0.0]";
    	String st = "[aid: 2; type: RIDER; first_name: Jake; last_name: Long; phone: 123-456-7890; picture: C:/Photo.jpg; is_active: false; rides: 0; ratings: 0; average_rating: 0.0]";
    	String str = "[aid: 3; type: BUSINESSOWNER; first_name: Bob; last_name: Hill; phone: 123-456-7890; picture: C:/Photo.jpg; is_active: false; rides: 0; ratings: 0; average_rating: 0.0]";
    	
    	if(driverID == 1 && riderID == 2 && ownerID == 3) {
    		if(a.toString().compareTo(s) == 0 && b.toString().compareTo(st) == 0 && c.toString().compareTo(str) == 0) {
    			initialized = true;
    		}
    	}
    	
    	assertTrue(initialized);
    }
    
    @Test @Order(2) void testActivateAccount() {
    	Account a = account_manager.viewAccountDetails(1); //aid: 1 should be the driver from previous test
    	boolean activated = false;
    	String str = "[aid: 1; type: DRIVER; first_name: John; last_name: Doe; phone: 123-456-7890; picture: C:/Photo.jpg; is_active: true; rides: 0; ratings: 0; average_rating: 0.0]";
    	a.activateAccount();
    	if(a.toString().compareTo(str) == 0) {
    		activated = true;
    	}
    	assertTrue(activated);
    }
    
    @Test  @Order(3) void testUpdateAccount() {
    	Account a = account_manager.viewAccountDetails(1);
    	boolean updated = false;
    	String str = "[aid: 1; type: DRIVER; first_name: Doe; last_name: John; phone: 123-456-7890; picture: C:/Photo.jpg; is_active: true; rides: 0; ratings: 0; average_rating: 0.0]";
    	a.updateAccount("Doe", "John", "123-456-7890", "C:/Photo.jpg", true);
    	if(a.toString().compareTo(str) == 0) {
    		updated = true;
    	}
    	assertTrue(updated);
    }
    
}
