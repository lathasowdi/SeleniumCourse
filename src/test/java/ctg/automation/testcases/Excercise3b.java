package ctg.automation.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Excercise3b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromr.driver", "C:/Users/lkumarasamy/Selenium/drivers/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		System.out.println("Navigate to website");
		driver.navigate().to("https://app-tst-training.azurewebsites.net/");
		driver.findElement(By.id("logout")).click();
		driver.manage().window().maximize();
		WebElement dropdown=driver.findElement(By.name("language"));
		Select setLanguage=new Select(dropdown);
		setLanguage.selectByVisibleText("French");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("superduper");
		
		driver.findElement(By.xpath("//body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")).click();
		
		
		driver.quit();

	}

}