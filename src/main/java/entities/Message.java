package entities;

import util.TimeDateFormatter;
import util.UniqueIdGenerator;

public class Message {
	
	private int mid; //Message ID
	private int aid;
	private String msg;
	private String date;
	
	public Message(int aid, String msg) {
		this.mid = UniqueIdGenerator.getUniqueID();
		this.msg = msg;
		this.aid = aid;
		this.date = TimeDateFormatter.fullTimeStamp(); 
	}

	public int getMessageID() {
		return mid;
	}
	
	public String toString() {
		String str = "[mid: " + mid +
					"; aid: " + aid +
					"; date: " + date +
					"; message: " + msg +
					"]";
		return str;
	}

}
