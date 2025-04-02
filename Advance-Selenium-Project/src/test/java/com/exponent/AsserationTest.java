package com.exponent;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ITestListenerTest.class)
public class AsserationTest {

	@Test
	public  void test1() {
		System.out.println("Asseration Test ----1");
		Assert.assertEquals(10, 10);
		System.out.println("Asseration Test ----1");
		System.out.println("Asseration Test ----1");
		System.out.println("Asseration Test ----1");
	}
	@Test
	public void test2() {
		SoftAssert sa=new SoftAssert();
		System.out.println("Test ---2");
		sa.assertEquals(11, 10);
		System.out.println("Test ---2");
		System.out.println("Test ---2");
		System.out.println("Test ---2");
		sa.assertAll();
	}
}
