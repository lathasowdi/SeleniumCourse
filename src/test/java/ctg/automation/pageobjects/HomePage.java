package ctg.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/p[4]/input[1]")			
	private WebElement btnShowMe;
	
	@FindBy(id = "bear")			
	private WebElement img1;

	@FindBy(xpath = "//*[@id=\"bear\"]")
	private WebElement bearImage;
	
	private WebDriver driver; 
	
	
	
	public HomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getBearImage() {
		return bearImage;
	}

	public void setBearImage(WebElement bearImage) {
		this.bearImage = bearImage;
	}

	public WebElement getImage() {
		return img1;
	}

	public void setImage1(WebElement img1) {
		this.img1 = img1;
	}

	
       public void clickBtnShowMe() {
		btnShowMe.click();
	}

	




}
