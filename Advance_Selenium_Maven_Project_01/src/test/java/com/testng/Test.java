package com.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.internal.LogManagerStatus;

public class Test {

	static Logger log= LogManager.getLogger(Test.class);
	public static void main(String[] args) {
		
		log.debug("Debug");
		log.info("Info");
		log.warn("Warn");
		log.error("Error");
		log.fatal("Fatal");
	}
}
