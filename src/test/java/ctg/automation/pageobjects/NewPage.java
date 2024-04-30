package ctg.automation.pageobjects;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import ctg.automation.connection.Connection;





public class NewPage 

{
	
	@FindBy(id = "crudConnection")
	private WebElement btnConnection;

	
	
	@FindBy(how= How.XPATH, using="/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	private WebElement txtFirstName;

	@FindBy(id = "lastName")			
	private WebElement txtLastName;

	@FindBy(id = "sex")			
	private WebElement listSex;

	@FindBy(id = "email")			
	private WebElement txtEmail;

	@FindBy(id = "telephone")			
	private WebElement txtTelephone;


	@FindBy(id = "company")			
	private WebElement txtCompany;

	@FindBy(id = "SSU")			
	private WebElement lstSSU;

	@FindBy(id = "seniority")			
	private WebElement lstSeniority;

	@FindBy(id = "interests")			
	private WebElement txtAddInfo;

	@FindBy(xpath = "//*[@id=\"add\"]/span/label")
	private WebElement btnAdd;

	private WebDriver driver;

		
	
	public NewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public NewPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	

	public NewPage createNewConnectionWith(Connection c) {
		btnConnection.click();
		
		txtFirstName.click();
		
		txtFirstName.clear();
		txtFirstName.sendKeys(c.getFirstName());

		txtLastName.clear();
		txtLastName.sendKeys(c.getLastName());	
		
		Select cboOptions = new Select(listSex);
		cboOptions.selectByVisibleText(c.getGender());
		
		txtEmail.clear();
		txtEmail.sendKeys(c.getEmail());

		txtTelephone.clear();
		txtTelephone.click();
		txtTelephone.sendKeys(c.getTelephone().toString());

		txtCompany.clear();
		txtCompany.sendKeys(c.getCompany());

		Select cboOptions2 = new Select(lstSSU);
		cboOptions2.selectByVisibleText(c.getSsu());

		Select cboOptions3 = new Select(lstSeniority);
		cboOptions3.selectByVisibleText(c.getSeniority());

		btnAdd.click();
		return this;

		
	}
}