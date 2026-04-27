package listener.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import webutil.WebUtil;

public class TestNGListener implements ITestListener {
	private WebUtil utilObj;
	ExtentTest exttest;

	public void onTestStart(ITestResult result) {
//		// TODO Auto-generated method stub
//		exttest = utilObj.getExtent();
//		utilObj.createExtentTest(result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		exttest.log(Status.PASS, "Succesfully");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		exttest.fail(result.getThrowable());
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		utilObj.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	//	WebUtilPage.genrateExtentReport();

	}

}
