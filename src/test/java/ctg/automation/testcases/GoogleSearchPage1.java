
package ctg.automation.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class GoogleSearchPage1  {
	
	public class GoogleSearchPage{
		private WebDriver driver;
		

		public GoogleSearchPage(WebDriver driver) {
			this.driver = driver;
			this.driver.get("https://www.google.com");
			this.driver.manage().window().maximize();
           this.driver.findElement(By.id("L2AGLb")).click();

		}

		public WebElement getTextboxSearch() {

			return this.driver.findElement(By.name("q"));
		}

		public WebElement getButtonSearch() {


			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
			WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
			return button;

		}
	}
		
		
	
	@Test
	public void SearchSelenium() {
		WebDriver driver = new ChromeDriver();
		GoogleSearchPage page = new GoogleSearchPage(driver);
		page.getTextboxSearch().sendKeys("Selenium");
		page.getButtonSearch().click();
		driver.quit();
	}
	
	@Test
	public void SearchCTG() {
		WebDriver driver = new ChromeDriver();
		GoogleSearchPage page = new GoogleSearchPage(driver);
		page.getTextboxSearch().sendKeys("CTG");
		page.getButtonSearch().click();
		driver.quit();
}
	
}


