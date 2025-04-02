package com.testng;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(value = com.testng.TestNGITestListnnerImpl.class)
public class AnnotationDemo {
	
	@BeforeSuite
	public void beoreSuite() {
		System.out.println("before suite");
	}

	@BeforeTest
	public void beoreTest() {
		System.out.println("before Test");
	}
	@BeforeClass
	public void beoreClass() {
		System.out.println("before class");
	}
	@BeforeMethod
	public void beoreMethos() {
		System.out.println("before method");
	}
	@Test
	public void test1() {
		System.out.println("Test Method--1");
	}
	@Test(dependsOnMethods = "test2")
	public void test3() {
		System.out.println("Test Method--3");
	}
	@Test(successPercentage = 30)
	public void test4() {
		System.out.println("Test Method--4");
		Assert.assertTrue(0>=0);
		System.out.println("Test Method--4");
		Assert.assertEquals(true, false);
	}
	@Test
	public void test2() {
		System.out.println("Test Method--2");
		Assert.assertTrue(0>=0);
		System.out.println("Test Method--2");
		Assert.assertEquals(true, false);
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
}
