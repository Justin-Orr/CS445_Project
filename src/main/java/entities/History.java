package entities;

import java.util.Hashtable;

public class History {
	
	private Hashtable<Integer, Message> history;
	
	public History() {
		this.history = new Hashtable<Integer, Message>();
	}
	
	public int addMessage(int aid, String msg) {
		Message message = new Message(aid, msg);
		int mid = message.getMessageID();
		history.put(mid, message);
		return mid;
	}
	
	public Hashtable<Integer, Message> viewMessageHistory() {
		return history;
	}

}
