package ctg.automation.helpers;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.model.Test;




public class TestListener  implements ITestListener{


	@Override
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
		if (testName == null) {
			testName = result.getMethod().getMethodName();
		}
		
		System.out.println(testName + "test is starting.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
			
		System.out.println( result.getMethod().getMethodName() +"test is success " ) ;	
		
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println( result.getMethod().getMethodName() +"test is failed " ) ;	
		
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println( result.getMethod().getMethodName() +"test is failed " ) ;
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println( result.getMethod().getMethodName() +"test is failed " ) ;
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println( context.getName() +"test is failed " ) ;
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println( context.getName() +"test finished " ) ;
		
	}


}


