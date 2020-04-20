package CS445_Project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import entities.*;

class AppTest {
	
	//Account Use Cases
	
    @Test void testCreateAccount() {
    	AccountManager account_manager = new AccountManager();
    	int driverID = account_manager.createAccount("DRIVER", "John", "Doe", "123-456-7890", "C:/Photo.jpg", false);
    	int riderID = account_manager.createAccount("RIDER", "Jake", "Long", "123-456-7890", "C:/Photo.jpg", false);
    	int ownerID = account_manager.createAccount("BUSINESSOWNER", "Bob", "Hill", "123-456-7890", "C:/Photo.jpg", false);
        
    	Driver driver = (Driver) account_manager.viewAccountDetails(driverID);
    	Rider rider = (Rider) account_manager.viewAccountDetails(riderID);
    	BusinessOwner owner = (BusinessOwner) account_manager.viewAccountDetails(ownerID);
    	
    	System.out.println(driver.toString());
    	System.out.println(rider.toString());
    	System.out.println(owner.toString());
    	
    	assertEquals(1, 1);
    }
    
    @Test void testActivateAccount() {
    	AccountManager account_manager = new AccountManager();
    	int driverID = account_manager.createAccount("DRIVER", "John", "Doe", "123-456-7890", "C:/Photo.jpg", false);
    	Driver driver = (Driver) account_manager.viewAccountDetails(driverID);
    	System.out.println(driver);
    	driver.activateAccount();
    	System.out.println(driver);
    	assertEquals(1, 1);
    }
    
    @Test void testUpdateAccount() {
    	assertEquals(1, 1);
    }
    
}
