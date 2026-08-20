package listener.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {

	int count=1;
	int maxCount=3;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count<=maxCount) {
			count++;
			System.out.println(result.getName()+" - "+ count+" time");
			return true;
		}
		return false;
	}

}
