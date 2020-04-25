package entities;

import java.util.Hashtable;
import interfaces.ReportBoundaryInterface;

public class ReportManager implements ReportBoundaryInterface{
	
	private static Hashtable<Integer, Report> list_of_reports = new Hashtable<Integer, Report>();
	
	public Hashtable<Integer, Report> viewAllReports() {
		return list_of_reports;
	}
	
	public Report viewReport(int pid) {
		return findReportByID(pid);
	}
	
	public int createReport(String name, String start_date, String end_date, int rides, String from_zip, String to_zip, int count) {
		Report report = new Report(name, start_date, end_date, rides, from_zip, to_zip, count);
		addReport(report);
		return report.getReportID();
	}
	
	private void addReport(Report report) {
		list_of_reports.put(report.getReportID(), report);
	}
	
	private Report findReportByID(int pid) {
		return list_of_reports.get(pid);
	}
	
	private void finfReportByZip(String from_zip, String to_zip) {
		//Do nothing
	}

}
