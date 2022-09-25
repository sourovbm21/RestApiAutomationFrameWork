package utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsListener implements ITestListener {

	protected  static ExtentReports reports;
	protected  static ExtentTest test;
	private static String resultpath = getresultpath();
	
	public static void deleteDirectory(File directory) {
		
		if (directory.exists()) {
			File[] files=directory.listFiles();
			if (null !=files) {
				for (int i=0;i<files.length;i++) {
					if(files[i].isDirectory()){
						deleteDirectory(files[1]);
					}else {
						files[i].delete();
					}
					
				}
			}
		}
		
		
	}

	String ReportLocation = "test-output/Report/" + resultpath + "/";

	private static String getresultpath() {
		resultpath = "test";
		if (!new File(resultpath).isDirectory()) {
			new File(resultpath);
		}

		return resultpath;
	}

	public void onTestStart(ITestResult result) {

		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName());
		System.out.println(result.getTestClass().getTestName());
		System.out.println(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {

		test.log(LogStatus.PASS, "test is pass");
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("i am on test failure" + test.getRunStatus());
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	reports=new ExtentReports(ReportLocation+"ExtentReport.html");
	test=reports.startTest("");
	}

	public void onFinish(ITestContext context) {

		reports.endTest(test);
		reports.flush();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}
