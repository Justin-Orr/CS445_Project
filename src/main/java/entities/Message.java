package entities;

public class Message {
	
	private int mid; //Message ID
	private int aid;
	private String msg;
	private String time;
	
	public Message(int aid, String msg) {
		this.mid = UniqueIdGenerator.getUniqueID();
		this.msg = msg;
		this.time = "Time"; //Grab formatted system time
	}

	public int getMessageID() {
		return mid;
	}

}
