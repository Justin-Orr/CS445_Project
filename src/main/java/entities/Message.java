package entities;

public class Message {
	
	private int mid; //Message ID
	
	public Message() {
		this.mid = UniqueIdGenerator.getUniqueID();
	}

}
