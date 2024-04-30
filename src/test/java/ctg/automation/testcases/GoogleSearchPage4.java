package ctg.automation.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GoogleSearchPage4 {
	public class GoogleSearchPage{


		@FindBy(name = "q")
		private WebElement searchBox;

		@FindBy(name = "btnK")
		private WebElement buttonSearch;

		@FindBy(linkText = "Français")
		private WebElement buttonFrench;

		@FindBy(partialLinkText = "Sélénium")
		private WebElement seleniumlink;

		private WebDriver driver;

		public GoogleSearchPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}


		public GoogleSearchPage switchToFrench() {
			buttonFrench.click();
			return this;

		}

		public GoogleSearchPage searchFor(String text) {
			searchBox.sendKeys(text);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
			wait.until(ExpectedConditions.elementToBeClickable(buttonSearch)).click();
			return new GoogleSearchPage(driver);
		}

		public GoogleSearchPage selectLink(String string) {
			driver.findElement(By.partialLinkText(string)).click();
			return this;

		}

		public boolean isShown() {
			return driver.getTitle().equals("Google");
		}

	}

	@Test
	public void SearchSelenium() {
		WebDriver driver = new ChromeDriver();
		GoogleSearchPage google = new GoogleSearchPage(driver);
		google.driver.get("https://www.google.com");
		google.driver.findElement(By.id("L2AGLb")).click();


		Assert.assertTrue(google.isShown());
		google.switchToFrench().searchFor("Selenium").selectLink("Sélénium");

	}

}
