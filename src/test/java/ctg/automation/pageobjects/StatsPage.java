package ctg.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class StatsPage 

{
private WebDriver driver;

public StatsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
public StatsPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);

	}

}