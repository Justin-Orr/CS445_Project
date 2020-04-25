package interfaces;

import java.util.Hashtable;
import entities.Report;

public interface ReportBoundaryInterface {

	public Hashtable<Integer, Report> viewAllReports();
	public Report viewReport(int pid);
	
}
