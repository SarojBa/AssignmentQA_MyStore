package com.util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " Test case started");	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test case passed is: " +result.getName());		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test case failed is: " +result.getName());	
		
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test case skipped is: " +result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
