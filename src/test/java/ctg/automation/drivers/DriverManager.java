package ctg.automation.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver == null) {
			setChromeDriver();
		}
		return driver;
	}
	
 
	public static void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/lkumarasamy/Selenium/drivers/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public static void setFireFoxDriver() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/lkumarasamy/Selenium/drivers/geckodriver-v0.34.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	public static void quitDriver() {
		if (!(driver == null)) {
			driver.quit();
		}
		driver = null;
	}
}