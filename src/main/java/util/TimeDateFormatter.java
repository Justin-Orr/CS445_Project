package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeDateFormatter {

	public static String timeStamp() {
		LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy, HH:mm:ss");
        return dtf.format(dateTime);
	}
	
}
