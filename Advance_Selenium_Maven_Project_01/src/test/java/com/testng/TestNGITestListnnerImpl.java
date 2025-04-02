package com.testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGITestListnnerImpl implements ITestListener {
	
	public void onStart(ITestContext context) {
		System.out.println("on start method execute--------------");
	}
	public void onFinish(ITestContext context) {
		System.out.println("on Finish method execute--------------");
	}
	public void onTestStart(ITestResult result) {
		System.out.println("on test start method execute--------------");
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test Success method execute--------------");
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("on test failure method execute--------------");
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("on Test Skipped method execute--------------");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("on Test Failed But With in Success Percentage method execute--------------");
	}
}
