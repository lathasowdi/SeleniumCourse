package ctg.automation.testcases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.WebDriverListener;



public class CustomListener implements WebDriverListener {
	
	public void afterClick(WebElement elelment)
	{
		System.out.println("I clicked on " +elelment.toString());
	}
	public void beforeClick(WebElement elelment)
	{
		System.out.println("I am going to click on " +elelment.toString());
	}
	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
		if(e.getTargetException() instanceof NoSuchElementException ) {
			
			
			File f = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			
			FileHandler.copy(f, new File("c:\\tmp\\screenshot.png"));
			System.out.println("NoSuchElemetException error. See screenshot.");
		}
		catch(IOException d) {
			d.printStackTrace();
		}
		}
	}
}
