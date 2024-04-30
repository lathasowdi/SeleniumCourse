package ctg.automation.testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Excercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromre.driver", "C:/Users/lkumarasamy/Selenium/drivers/chromedriver-win64/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:/Users/lkumarasamy/Selenium/drivers/geckodriver-v0.34.0-win64/geckodriver.exe");
		//WebDriver driver=new ChromeDriver();
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://be.ctg.com/");
		System.out.println("The title of the page" + driver.getTitle());
		System.out.println("The test has ended. Have a very good day");
		//driver.close();
		driver.quit();

	}

}
