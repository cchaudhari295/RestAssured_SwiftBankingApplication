package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
	
	
	private static final Logger logger = LogManager.getLogger(TestListeners.class);
	
	  public void onTestStart(ITestResult result) {
		  System.out.println("Starting test suite....");
		  logger.info("Starting test suite...");
	  
	  }
}
