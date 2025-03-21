package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	
	 public static final ExtentReports extentReports = new ExtentReports(); 
	  
	 	public synchronized static ExtentReports createExtentReports() {  	// two class ond - Extentsreports andExtentSparkReporter - eth provide chyunath aventstack
	 		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); // ./ represent the current project location, extent- report - folder name, extend-report.html - file 
	 		reporter.config().setReportName("7RMart  Project");  // ExtentSparkReporter class provide chyunath method ane - config and setreportname provide 
	 		extentReports.attachReporter(reporter); // use chyunath connect chyn vendi 2 class obj name veche matta classinte obje name pass chyuvan
	 		extentReports.setSystemInfo("Organization", "Obsqura"); 
	 		extentReports.setSystemInfo("Name", "Abhi"); 
	 		return extentReports; 
	 	}

}
