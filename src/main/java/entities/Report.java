package entities;

import java.util.Hashtable;

import util.UniqueIdGenerator;

public class Report {
	
	private int pid; //Report ID
	private String name;
	private String start_date;
	private String end_date;
	private int rides;
	private Hashtable<String, Detail> details;
	
	public Report(String name, String start_date, String end_date, int rides, String from_zip, String to_zip, int count) {
		this.pid = UniqueIdGenerator.getUniqueID();
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.rides = rides;
		this.details = new Hashtable<String, Detail>();
		addDetail(from_zip, to_zip, count);
	}
	
	public void addDetail(String from_zip, String to_zip, int count) {
		details.put(from_zip, new Detail(from_zip, to_zip, count));
	}
	
	public int getReportID() {
		return pid;
	}
	
	public String toString() {
		String str = "[pid: " + pid +
				"; name: " + name +
				"; start_date: " + start_date +
				"; end_date: " + end_date +
				"; rides: " + rides +
				"; details: " + details.toString() +
				"]";
		return str;
	}
	
	class Detail {
		private String from_zip;
		private String to_zip;
		private int count;
		
		public Detail(String from_zip, String to_zip, int count) {
			this.from_zip = from_zip;
			this.to_zip = to_zip;
			this.count = count;
		}
		
		public String getFromZip() {
			return from_zip;
		}
		
		public String getToZip() {
			return to_zip;
		}
		
		public int getCount() {
			return count;
		}
		
		public void setFromZip(String from_zip) {
			this.from_zip = from_zip;
		}
		
		public void setToZip(String to_zip) {
			this.to_zip = to_zip;
		}
		
		public void setCount(int count) {
			this.count = count;
		}
		
		public String toString() {
			String str = "[from_zip: " + from_zip +
					"; to_zip: " + to_zip +
					"; count: " + count +
					"]";
			return str;
		}
		
	}

}
