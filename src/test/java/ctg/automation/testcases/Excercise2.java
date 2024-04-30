package ctg.automation.testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Excercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromr.driver", "C:/Users/lkumarasamy/Selenium/drivers/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		System.out.println("Navigate to google");
		driver.navigate().to("https://www.google.com/");
		String title1=driver.getTitle();
		System.out.println("The title of the page" + title1);
		
		System.out.println("Navigate to bing");
		driver.navigate().to("https://www.bing.com/");
		System.out.println("The title of the page" + driver.getTitle());
		
		System.out.println("Navigate to google");
		driver.navigate().back();
		
		
		String title2=driver.getTitle();
		System.out.println("The title of the page" + title2);
		if (title1.equalsIgnoreCase(title2)) {
			System.out.println("The page title are same");
		}
		System.out.println("The test has ended. Have a very good day");
		driver.navigate().refresh();
		//driver.close();
		driver.quit();

	}

}
