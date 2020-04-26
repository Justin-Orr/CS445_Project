package entities;

import java.util.ArrayList;

public class History {
	
	private ArrayList<Message> history;
	
	public History() {
		this.history = new ArrayList<Message>();
	}
	
	public int addMessage(int aid, String msg) {
		Message message = new Message(aid, msg);
		int mid = message.getMessageID();
		history.add(message);
		return mid;
	}
	
	public ArrayList<Message> viewMessageHistory() {
		return history;
	}

}
