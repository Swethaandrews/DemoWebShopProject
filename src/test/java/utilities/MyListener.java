package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyListener implements ITestListener{
	ScreenshotUtilities screenshotUtil;
	ExtentReports extentReports;
	ExtentTest 	extentTest; 
	

	
	public void onTestFailure(ITestResult result) {
	    try {
			ScreenshotUtilities.takeScreenshot();
			System.out.println("Taking screenshot");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  }
public void onStart(ITestContext context) {
	 screenshotUtil=new ScreenshotUtilities();
	 
	 System.out.println("TestNG Started");
	 ExtentSparkReporter sparkreporter = new ExtentSparkReporter("Extentreport.html");
	 extentReports = new ExtentReports();
		extentReports.attachReporter(sparkreporter);
		// on the report display more information about OS, browser, java etc
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Host Name", System.getProperty("user.name"));
		extentReports.setSystemInfo("Browser", "Chrome");
		
		extentTest=	extentReports.createTest(context.getName());
			
	  }

public void onFinish(ITestContext context) {
	extentReports.flush();
	try {
		Desktop.getDesktop().browse(new File("Extentreport.html").toURI());
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
}

