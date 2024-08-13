package com.trello.qsp.genericutility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends BaseClass implements ITestListener {
@Override
public void onTestFailure(ITestResult result)
{
System.out.println("TestCase Failed");
try
{
	failedTestCase(result.getMethod().getMethodName());
	
} catch(Exception e)
{
//TODO handle exception
}
}

@Override
public void onTestSkipped(ITestResult result)
{
	System.out.println("The method has been skipped");	
}
}
