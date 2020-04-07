package CS445_Project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import entities.*;

class AppTest {
	
	//Vehicle Tests
	
    @Test void testVehicleAvailableSeatGetter() {
    	Vehicle c = new Vehicle(4, 4, "CAR");
        assertEquals(c.getAvailableSeats(), 4);
    }
    
    @Test void testVehicleTotalSeatGetter() {
    	Vehicle c = new Vehicle(4, 4, "CAR");
        assertEquals(c.getTotalSeats(), 4);
    }
    
    @Test void testVehicleTypeGetter() {
    	Vehicle c = new Vehicle(4, 4, "CAR");
        assertEquals(c.getVehicleType(), "CAR");
    }
    
    @Test void testVehicleAvailableSeatSetter() {
    	Vehicle c = new Vehicle(4, 4, "CAR");
    	c.setAvailableSeats(2);
        assertEquals(c.getAvailableSeats(), 2);
    }
    
    @Test void testVehicleTotalSeatSetter() {
    	Vehicle c = new Vehicle(4, 4, "CAR");
    	c.setTotalSeats(2);
        assertEquals(c.getTotalSeats(), 2);
    }
    
    @Test void testVehicleTypeSetter() {
    	Vehicle c = new Vehicle(4, 4, "CAR");
    	c.setVehicleType("SUV");
        assertEquals(c.getVehicleType(), "SUV");
    }
    
    @Test void testVehicleEquals() {
    	Vehicle c = new Vehicle(4, 4, "CAR");
    	Vehicle v = new Vehicle(4, 4, "CAR");
    	assertTrue(c.equals(v));
    }
    
    //Person Tests
    
    @Test void testPersonGetName() {
    	Person p = new Person("John Doe", 20);
    	assertEquals(p.getName(), "John Doe");
    }
    
    @Test void testPersonGetAge() {
    	Person p = new Person("John Doe", 20);
    	assertEquals(p.getAge(), 20);
    }
    
    @Test void testPersonSetName() {
    	Person p = new Person("John Doe", 20);
    	p.setName("Doe John");
    	assertEquals(p.getName(), "Doe John");
    }
    
    @Test void testPersonSetAge() {
    	Person p = new Person("John Doe", 20);
    	p.setAge(30);
    	assertEquals(p.getAge(), 30);
    }
    
    @Test void testPersonEquals() {
    	Person p = new Person("John Doe", 20);
    	Person q = new Person("John Doe", 20);
    	assertTrue(p.equals(q));
    }
    
    //Rating Tests
    
    @Test void testGetRating() {
    	Rating r = new Rating(5);
    	assertEquals(r.getRating(), 5);
    }
    
    @Test void testSetRating() {
    	Rating r = new Rating(5);
    	r.setRating(0);
    	assertEquals(r.getRating(), 0);
    }
    
    @Test void testEqualRatings() {
    	Rating r = new Rating(5);
    	Rating s = new Rating(5);
    	assertTrue(r.equals(s));
    }
    
    //Account Tests
    
    @Test void testAccountIsNil() {
    	Account a = new Account("DRIVER");
    	assertFalse(a.isNil());
    }
    
    @Test void testAccountType() {
    	Account a = new Account("DRIVER");
    	assertEquals(a.getAccountType(), "DRIVER");
    }
    
    @Test void testSetAccountType() {
    	Account a = new Account("DRIVER");
    	a.setAccountType("RIDER");
    	assertEquals(a.getAccountType(), "RIDER");
    }
    
    //User Tests
    
    @Test void testGetUserAccount() {
    	Account a = new Account("DRIVER");
    	User u = new User("John Doe", 20, "DRIVER");
    	assertFalse(u.getAccount().equals(a));
    }
    
    @Test void testUserEquals() {
    	User u = new User("John Doe", 20, "DRIVER");
    	User v = new User("John Doe", 20, "DRIVER");
    	assertFalse(u.equals(v)); //Should fail due to unique ID numbers on the accounts
    }
  
    //Driver Tests
    
    @Test void testGetDriverVehicle() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Vehicle x = new Vehicle(4, 3, "CAR");
    	assertTrue(d.getVehicle().equals(x));
    }
    
    @Test void testGetDriverRating() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	assertTrue(d.getRating().equals(new Rating(5)));
    }
    
    @Test void testSetDriverVehicle() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	v = new Vehicle(6, 5, "SUV");
    	d.setVehicle(v);
    	assertTrue(d.getVehicle().equals(new Vehicle(6, 5, "SUV")));
    }
    
    @Test void testSetDriverRating() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rating r = new Rating(0);
    	d.setRating(r);
    	assertTrue(d.getRating().equals(new Rating(0)));
    }
    
    @Test void testDriverEquals() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Vehicle x = new Vehicle(4, 3, "CAR");
    	Driver e = new Driver("John Doe", 20, x);
    	assertFalse(d.equals(e));
    }
    
    //BusinessOwner Tests
    
    @Test void testGetBusinessOwnerCompanyName() {
    	BusinessOwner b = new BusinessOwner("John Doe", 40, "Uber");
    	assertEquals(b.getCompanyName(), "Uber");
    }
    
    @Test void testSetBusinessOwnerName() {
    	BusinessOwner b = new BusinessOwner("John Doe", 40, "Uber");
    	b.setCompanyName("Lyft");
    	assertEquals(b.getCompanyName(), "Lyft");
    }
    
    @Test void testBusinessOwnerEquals() {
    	BusinessOwner b = new BusinessOwner("John Doe", 40, "Uber");
    	BusinessOwner c = new BusinessOwner("John Doe", 40, "Uber");
    	assertFalse(b.equals(c));
    }
    
    //Rider Tests
    
    @Test void testGetRiderRating() {
    	Rider r = new Rider("John Doe", 20);
    	Rating s = new Rating(5);
    	assertTrue(r.getRating().equals(s));
    }
    
    @Test void testSetRiderRating() {
    	Rider r = new Rider("John Doe", 20);
    	r.setRating(new Rating(0));
    	assertTrue(r.getRating().equals(new Rating(0)));
    }
    
    @Test void testRiderEquals() {
    	Rider r = new Rider("John Doe", 20);
    	Rider s = new Rider("John Doe", 20);
    	assertFalse(r.equals(s));
    }
    
    //Ride Tests
    
    @Test void testGetPickUpLocation() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rider[] riders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride r = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", d, riders);
    	assertEquals(r.getPickUpLocation(), "IIT");
    }
    
    @Test void testGetDestination() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rider[] riders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride r = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", d, riders);
    	assertEquals(r.getDestination(), "Millinium Park");
    }
    
    @Test void testGetDate() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rider[] riders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride r = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", d, riders);
    	assertEquals(r.getDate(), "March 3");
    }
    
    @Test void testGetPickUpTime() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rider[] riders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride r = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", d, riders);
    	assertEquals(r.getPickUpTime(), "5:00pm");
    }
    
    @Test void testGetDriver() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rider[] riders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride r = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", d, riders);
    	assertFalse(r.getDriver().equals(new Driver("John Doe", 20, new Vehicle(4, 3, "CAR"))));
    }
    
    @Test void testGetRiders() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rider[] riders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride r = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", d, riders);
    	Rider[] ridersCopy = {new Rider("JD", 21), new Rider("DJ", 22)};
    	
    	boolean b = false;
    	if(riders[0].equals(ridersCopy[0]) && riders[1].equals(ridersCopy[1]))
    		b = true;
    	assertFalse(b);
    }
    
    @Test void testSetPickUpLocation() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rider[] riders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride r = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", d, riders);
    	
    	r.setPickUpLocation("Hyde Park");
    	assertEquals(r.getPickUpLocation(), "Hyde Park");
    }
    
    @Test void testSetDestination() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rider[] riders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride r = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", d, riders);
    	
    	r.setDestination("IIT");
    	assertEquals(r.getDestination(), "IIT");
    }
    
    @Test void testSetDate() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rider[] riders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride r = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", d, riders);
    	
    	r.setDate("March 11");
    	assertEquals(r.getDate(), "March 11");
    }
    
    @Test void testSetPickUpTime() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rider[] riders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride r = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", d, riders);
    	
    	r.setPickUptime("6:00pm");
    	assertEquals(r.getPickUpTime(), "6:00pm");
    }
    
    @Test void testSetDriver() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rider[] riders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride r = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", d, riders);
    	
    	Driver e = new Driver("Doe John", 21, new Vehicle(6, 5, "SUV"));
    	r.setDriver(e);
    	assertFalse(r.getDriver().equals(new Driver("Doe John", 21, new Vehicle(6, 5, "SUV"))));
    }
    
    @Test void testSetRiders() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rider[] riders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride r = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", d, riders);
    	Rider[] newRiders = {new Rider("AJ", 31), new Rider("TJ", 32)};
    	
    	Rider[] newRidersCopy = {new Rider("AJ", 31), new Rider("TJ", 32)};
    	r.setRiders(newRidersCopy);
    	boolean b = false;
    	if(riders[0].equals(newRiders[0]) && riders[1].equals(newRiders[1]))
    		b = true;
    	assertFalse(b);
    }
    
    @Test void testRideEquals() {
    	Vehicle v = new Vehicle(4, 3, "CAR");
    	Driver d = new Driver("John Doe", 20, v);
    	Rider[] riders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride r = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", d, riders);
    	
    	Vehicle x = new Vehicle(4, 3, "CAR");
    	Driver e = new Driver("John Doe", 20, x);
    	Rider[] otherRiders = {new Rider("JD", 21), new Rider("DJ", 22)};
    	Ride s = new Ride("IIT", "Millinium Park", "March 3", "5:00pm", e, otherRiders);
    	
    	assertFalse(r.equals(s)); //Once again unique driver and rider ID's cause this to fail
    }
    
}
