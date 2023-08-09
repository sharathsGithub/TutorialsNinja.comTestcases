package com.tutorialsninja.qa.listeners;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tutuorialsninja.qa.utils.ExtentReporter;

public class Mylistenerssecondfile implements ITestListener {

	public ExtentReports reportfile= ExtentReporter.generateExtentReport(); 
	 public ExtentTest extentestreport;
public void onStart(ITestContext context) {
	 System.out.println("The exection has Strated");
}

public void onTestStart(ITestResult result) {
System.out.println("ontestmethod has started");
	String testname=result.getName();
 extentestreport = reportfile.createTest(testname);
extentestreport.log(Status.INFO, MarkupHelper.createLabel(testname, ExtentColor.BLUE));

}


public void onTestSuccess(ITestResult result) {
	System.out.println("ontest is susccesss");
	String testname=result.getName();
	 extentestreport = reportfile.createTest(testname);
	extentestreport.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test"+testname, ExtentColor.ORANGE));
}

public void onTestFailure(ITestResult result) {
	
	System.out.println("on test is failed");
	String testname=result.getName();
	 extentestreport = reportfile.createTest(testname);
	 extentestreport.log(Status.INFO, MarkupHelper.createLabel("Name of the failed test"+testname, ExtentColor.BLUE));
	extentestreport.log(Status.FAIL, MarkupHelper.createLabel(testname, ExtentColor.RED));
String screenshotpath=System.getProperty("user.dir")+"\\Screenshot\\"+testname+".png";
File screenshotFile=new File(screenshotpath);
if(screenshotFile.exists())
{
	extentestreport.fail("CAptured screenshot is below: "+extentestreport.addScreenCaptureFromPath(screenshotpath));
}
}

public void onTestSkipped(ITestResult result) {

	String testname=result.getName();
	 extentestreport = reportfile.createTest(testname);
	extentestreport.log(Status.SKIP, MarkupHelper.createLabel(testname, ExtentColor.PINK));
}

public void onFinish(ITestContext context) {

reportfile.flush();

}


}
