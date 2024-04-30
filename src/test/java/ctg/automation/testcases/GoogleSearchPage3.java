
package ctg.automation.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
public class GoogleSearchPage3{

	public class GoogleSearchPage{
		private WebDriver driver;

		public GoogleSearchPage(WebDriver driver) {
			this.driver = driver;
			this.driver.get("https://www.google.com");
			this.driver.manage().window().maximize();
this.driver.findElement(By.id("L2AGLb")).click();

}

		@FindBy(how = How.NAME, using = "q")
		private WebElement searchBox;
		
		@FindBy(how = How.NAME, using = "btnK")
		private WebElement buttonSearch;
		
	
		
			
		public void searchFor(String text) {
		searchBox.sendKeys(text);
		this.driver.findElement(By.name("q")).sendKeys(text);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.elementToBeClickable(buttonSearch)).click();
		}
}
		
		
@Test
public void SearchSelenium() {
	WebDriver driver = new ChromeDriver();
	GoogleSearchPage page = new GoogleSearchPage(driver);
	PageFactory.initElements(driver, page);
	page.searchFor("Selenium");
driver.quit();
}
	
	
	
	
}


