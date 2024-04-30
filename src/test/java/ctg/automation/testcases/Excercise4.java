package ctg.automation.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Excercise4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromr.driver", "C:/Users/lkumarasamy/Selenium/drivers/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		System.out.println("Test Automation Started");
		driver.navigate().to("https://app-tst-training.azurewebsites.net/");
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@id='logout']")).click();
		
		Thread.sleep(3000);
		WebElement dropdown=driver.findElement(By.name("language"));
		Select setLanguage=new Select(dropdown);
		setLanguage.selectByVisibleText("French");
		
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("#username")).sendKeys("admin");
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#password")).sendKeys("superduper");
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.className("content")).click();
		
		Thread.sleep(3000);
		
		System.out.println("Test Automation ended");
		
		driver.quit();

	}

}
