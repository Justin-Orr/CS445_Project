package entities;

public class Report {
	
	private int pid; //Report ID
	
	public Report() {
		this.pid = UniqueIdGenerator.getUniqueID();
	}

}
