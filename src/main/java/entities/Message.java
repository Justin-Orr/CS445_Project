package entities;

import util.UniqueIdGenerator;

public class Message {
	
	private int mid; //Message ID
	private int aid;
	private String msg;
	private String time;
	
	public Message(int aid, String msg) {
		this.mid = UniqueIdGenerator.getUniqueID();
		this.msg = msg;
		this.aid = aid;
		this.time = "HH:MM:SS"; //Grab formatted system time
	}

	public int getMessageID() {
		return mid;
	}
	
	public String toString() {
		String str = "[mid: " + mid +
					"; aid: " + aid +
					"; time: " + time +
					"; message: " + msg +
					"]";
		return str;
	}

}
