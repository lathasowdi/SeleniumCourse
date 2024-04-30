
package ctg.automation.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class GoogleSearchPage2 {
	public class GoogleSearchPage{
		private WebDriver driver;

		public GoogleSearchPage(WebDriver driver) {
			this.driver = driver;
			this.driver.get("https://www.google.com");
			this.driver.manage().window().maximize();

			this.driver.findElement(By.id("L2AGLb")).click();

}

		public void searchFor(String text) {
		
			this.driver.findElement(By.name("q")).sendKeys(text);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
			wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK"))).click();
			
		}

}
	
@Test
public void SearchSelenium() {
	WebDriver driver = new ChromeDriver();
	GoogleSearchPage page = new GoogleSearchPage(driver);
	page.searchFor("Selenium");
driver.quit();
}
}


