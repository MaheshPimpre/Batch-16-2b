package com.exponent;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class IsuiteListenerTest implements ISuiteListener{
	public void onStart(ISuite suite) {
		System.out.println("On test method start---------------");
	}
	public void onFinish(ISuite suite) {
		System.out.println("On Test method finish----------------");
	}

}
