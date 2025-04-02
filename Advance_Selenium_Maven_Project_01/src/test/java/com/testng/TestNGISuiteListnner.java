package com.testng;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.annotations.Test;

public class TestNGISuiteListnner implements ISuiteListener{

	
	public void onStart(ISuite suite) {
		System.out.println("On start method execute================");
	}
	
	public void onFinish(ISuite suite) {
		System.out.println("On Finish method execute================");
	}
}
