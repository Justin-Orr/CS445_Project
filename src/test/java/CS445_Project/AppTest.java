package CS445_Project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Hashtable;

import entities.*;

@TestMethodOrder(OrderAnnotation.class)
class AppTest {
	
	//The @TestMethodOrder and @Order notations go hand in hand to ensure methods are tested in a specified order
	AccountManager account_manager;
	RatingManager rating_manager;
	RideManager ride_manager;
	RideRequestManager ride_request_manager;
	ReportManager report_manager;
	
	//Account Use Cases
	@BeforeEach public void initialize() {
		account_manager = new AccountManager();
		rating_manager = new RatingManager();
		ride_manager = new RideManager();
		ride_request_manager = new RideRequestManager();
		report_manager = new ReportManager();
	}
	
    @Test @Order(1) void testCreateAccount() {
    	int driverID = account_manager.createAccount("DRIVER", "John", "Doe", "123-456-7890", "C:/Photo.jpg", false);
    	int riderID = account_manager.createAccount("RIDER", "Jake", "Long", "123-456-7890", "C:/Photo.jpg", false);
    	int ownerID = account_manager.createAccount("BUSINESSOWNER", "Bob", "Hill", "123-456-7890", "C:/Photo.jpg", false);
        
    	boolean initialized = false;
    	Account a = account_manager.viewAccountDetails(driverID);
    	Account b = account_manager.viewAccountDetails(riderID);
    	Account c = account_manager.viewAccountDetails(ownerID);
    	
    	String s = "[aid: 1; type: DRIVER; date_created: D-MMM-YYYY, HH:MM:SS; first_name: John; last_name: Doe; phone: 123-456-7890; picture: C:/Photo.jpg; is_active: false; rides: 0; ratings: 0; average_rating: 0.0]";
    	String st = "[aid: 2; type: RIDER; date_created: D-MMM-YYYY, HH:MM:SS; first_name: Jake; last_name: Long; phone: 123-456-7890; picture: C:/Photo.jpg; is_active: false; rides: 0; ratings: 0; average_rating: 0.0]";
    	String str = "[aid: 3; type: BUSINESSOWNER; date_created: D-MMM-YYYY, HH:MM:SS; first_name: Bob; last_name: Hill; phone: 123-456-7890; picture: C:/Photo.jpg; is_active: false; rides: 0; ratings: 0; average_rating: 0.0]";
    	
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
    	String str = "[aid: 1; type: DRIVER; date_created: D-MMM-YYYY, HH:MM:SS; first_name: John; last_name: Doe; phone: 123-456-7890; picture: C:/Photo.jpg; is_active: true; rides: 0; ratings: 0; average_rating: 0.0]";
    	a.activateAccount();
    	if(a.toString().compareTo(str) == 0) {
    		activated = true;
    	}
    	assertTrue(activated);
    }
    
    @Test  @Order(3) void testUpdateAccount() {
    	Account a = account_manager.viewAccountDetails(1);
    	boolean updated = false;
    	String str = "[aid: 1; type: DRIVER; date_created: D-MMM-YYYY, HH:MM:SS; first_name: Doe; last_name: John; phone: 123-456-7890; picture: C:/Photo.jpg; is_active: true; rides: 0; ratings: 0; average_rating: 0.0]";
    	a.updateAccount("Doe", "John", "123-456-7890", "C:/Photo.jpg", true);
    	if(a.toString().compareTo(str) == 0) {
    		updated = true;
    	}
    	assertTrue(updated);
    }
    
    @Test @Order(4) void testViewAllAccounts() {
    	Hashtable<Integer, Account> accounts = account_manager.viewAllAccounts();
    	String str = "[aid: 1; type: DRIVER; date_created: D-MMM-YYYY, HH:MM:SS; first_name: Doe; last_name: John; phone: 123-456-7890; picture: C:/Photo.jpg; is_active: true; rides: 0; ratings: 0; average_rating: 0.0]" +
    			"[aid: 2; type: RIDER; date_created: D-MMM-YYYY, HH:MM:SS; first_name: Jake; last_name: Long; phone: 123-456-7890; picture: C:/Photo.jpg; is_active: false; rides: 0; ratings: 0; average_rating: 0.0]" +
    			"[aid: 3; type: BUSINESSOWNER; date_created: D-MMM-YYYY, HH:MM:SS; first_name: Bob; last_name: Hill; phone: 123-456-7890; picture: C:/Photo.jpg; is_active: false; rides: 0; ratings: 0; average_rating: 0.0]";
    	String str2 = "";
    	for(int i = 1; i <= accounts.size(); i++) {
    		Account a = accounts.get(i);
    		str2 += a.toString();
    	}
    	assertEquals(0, str.compareTo(str2));
    }
    
    @Test @Order(5) void testCreateRide() {
    	int rid = ride_manager.createRide(1, "Hyde Park", "Chicago", "D-MMM-YYYY", "12:00:00", 4, 5.0, "No smoking"); 
    	Ride ride = ride_manager.viewRideDetail(rid);
    	String str = "[rid: 4; pickUp: Hyde Park; destination: Chicago; date: D-MMM-YYYY; pickUptime: 12:00:00; driverID: 1; riderID: 0; max_passengers: 4; amount_per_passenger: 5.0; conditions: No smoking]";
    	assertEquals(0, str.compareTo(ride.toString()));
    }
    
    @Test @Order(6) void testUpdateRide() {
    	Ride ride = ride_manager.viewRideDetail(4);
    	ride.updateRideDetails("Chicago", "Hyde Park", "D-MMM-YYYY", "12:00:00", 4, 5.0, "No smoking");
    	String str = "[rid: 4; pickUp: Chicago; destination: Hyde Park; date: D-MMM-YYYY; pickUptime: 12:00:00; driverID: 1; riderID: 0; max_passengers: 4; amount_per_passenger: 5.0; conditions: No smoking]";
    	assertEquals(0, str.compareTo(ride.toString()));
    }
    
    @Test @Order(7) void testCreateRideRequest() {
    	int jid = ride_request_manager.requestToJoinRide(4, 2, 2, null, null);
    	RideRequest request = ride_request_manager.viewRideRequestDetails(jid);
    	String str = "[jid: 5; aid: 2; passengers: 2; ride_confirmed: null; pickup_confirmed: null]";
    	assertEquals(0, str.compareTo(request.toString()));
    }
    
    @Test @Order(8) void testDenyRideRequest() {
    	ride_request_manager.denyRequest(1);
    	RideRequest request = ride_request_manager.viewRideRequestDetails(5);
    	String str = "[jid: 5; aid: 2; passengers: 2; ride_confirmed: false; pickup_confirmed: null]";
    	assertEquals(0, str.compareTo(request.toString()));
    }
    
    @Test @Order(9) void testAcceptRideRequest() {
    	ride_request_manager.confirmRequest(1);
    	RideRequest request = ride_request_manager.viewRideRequestDetails(5);
    	String str = "[jid: 5; aid: 2; passengers: 2; ride_confirmed: true; pickup_confirmed: null]";
    	assertEquals(0, str.compareTo(request.toString()));
    }
    
    @Test @Order(10) void testConfirmPassengerPickup() {
    	ride_request_manager.confirmPassengerPickup(1);
    	RideRequest request = ride_request_manager.viewRideRequestDetails(5);
    	String str = "[jid: 5; aid: 2; passengers: 2; ride_confirmed: true; pickup_confirmed: true]";
    	assertEquals(0, str.compareTo(request.toString()));
    }
    
    @Test @Order(11) void testAddMessage() {
    	Rider rider = (Rider) account_manager.viewAccountDetails(2);
    	rider.addMessage("Hello");
    	Driver driver = (Driver) account_manager.viewAccountDetails(1);
    	driver.addMessage("Hi, I just arrived.");
    	Ride ride = ride_manager.viewRideDetail(4);
    	History history = ride.getMessageHistory();
    	Hashtable<Integer, Message> messages = history.viewMessageHistory();
    	Message msg1 = messages.get(6);
    	Message msg2 = messages.get(7);
    	boolean equal = false;
    	String str1 = "[mid: 6; aid: 2; time: HH:MM:SS; message: Hello]";
    	String str2 = "[mid: 7; aid: 1; time: HH:MM:SS; message: Hi, I just arrived.]";
    	if(msg1.toString().compareTo(str1) == 0 && msg2.toString().compareTo(str2) == 0) {
    		equal = true;
    	}
    	assertTrue(equal);
    }
    
    @Test @Order(12) void testViewMessageHistory() {
    	Ride ride = ride_manager.viewRideDetail(4);
    	History history = ride.getMessageHistory();
    	Hashtable<Integer, Message> messages = history.viewMessageHistory();
    	String str = "{7=[mid: 7; aid: 1; time: HH:MM:SS; message: Hi, I just arrived.], 6=[mid: 6; aid: 2; time: HH:MM:SS; message: Hello]}";
    	assertEquals(0, messages.toString().compareTo(str));
    }
    
    @Test @Order(13) void testViewAllReports() {
    	report_manager.createReport("Rides taken between two dates", "DD-MMM-YYYY", "DD-MMM-YYYY", 1, "XXXXX", "XXXXX", 1);
    	Hashtable<Integer, Report> reports = report_manager.viewAllReports();
    	String str = "{8=[pid: 8; name: Rides taken between two dates; start_date: DD-MMM-YYYY; end_date: DD-MMM-YYYY; rides: 1; details: {XXXXX=[from_zip: XXXXX; to_zip: XXXXX; count: 1]}]}";
    	assertEquals(0, reports.toString().compareTo(str));
    }
    
    @Test @Order(14) void testViewReport() {
    	Report report = report_manager.viewReport(8);
    	String str = "[pid: 8; name: Rides taken between two dates; start_date: DD-MMM-YYYY; end_date: DD-MMM-YYYY; rides: 1; details: {XXXXX=[from_zip: XXXXX; to_zip: XXXXX; count: 1]}]";
    	assertEquals(0, report.toString().compareTo(str));
    }
    
}
