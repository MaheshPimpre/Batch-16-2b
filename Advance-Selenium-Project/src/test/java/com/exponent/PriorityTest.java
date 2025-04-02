package com.exponent;

import org.testng.annotations.Test;

public class PriorityTest {

	@Test//(groups = {"No"})
	public void habc() {
		System.out.println("Test 1");
	}
	@Test(groups = {"Yes"})
	public void pqr() {
		System.out.println("Test 2");
	}
	@Test
	public void mno() {
		System.out.println("Test 3");
	}
	@Test//(groups = {"No"})
	public void xyz() {
		System.out.println("Test 4");
	}
	@Test
	public void efg() {
		System.out.println("Test 5");
	}
}
