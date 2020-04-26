package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeDateFormatter {

	public static String fullTimeStamp() {
		LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy, HH:mm:ss");
        return dtf.format(dateTime);
	}
	
	public static String dateTimeStamp() {
		LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        return dtf.format(dateTime);
	}
	
	public static String timeStamp() {
		LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        return dtf.format(dateTime);
	}
	
}
