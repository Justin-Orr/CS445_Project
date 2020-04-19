package entities;

public class Rating {
	
	private int sid; //Rating ID
	
	private int rid;
	private int sent_by_id;
	private String first_name;
	private String date;
	
	private int rating; //Should be between 1 and 5
	private String comment;
	
	public Rating(int rid, int sent_by_id, String first_name, String date, int rating, String comment) {
		this.sid = UniqueIdGenerator.getUniqueID();
		this.rid = rid;
		this.sent_by_id = sent_by_id;
		this.first_name = first_name;
		this.date = date;
		this.rating = rating;
		this.comment = comment;
	}
	
	public int getRatingID() {
		return sid;
	}

	public int getRater() {
		return sent_by_id;
	}

}
