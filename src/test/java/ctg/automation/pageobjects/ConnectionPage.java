package ctg.automation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ctg.automation.connection.Connection;
import ctg.automation.connection.MyConnectionsResultTable;




public class ConnectionPage 

{

	@FindBy(xpath = "//a[contains(text(),'Connections')]")			
	private WebElement btnConnections;


	@FindBy(id = "searchBy")
	private WebElement lstSearchBy;

	@FindBy(id = "searchTerm")			
	private WebElement txtSearchTerm;

	@FindBy(how = How.ID, using = "myrecords")			
	private WebElement divMyConnections;

	@FindBy(xpath = "//*[@id=\"records\"]/table")	
	private WebElement tabel;

	private WebDriver driver;

	private MyConnectionsResultTable resultTable;


	public ConnectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public ConnectionPage( ) {
		PageFactory.initElements(DriverManager.getDriver(), this);

	}


	public void resetAddressBook() {
		JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
		executor.executeScript("resetAddressBook(false)", false);
	}

	public void populateForTesting() {
		JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
		executor.executeScript("populateForTesting(false)", false);

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

	public ConnectionPage searchConnecitonsByFirstName(Connection c) {
		btnConnections.click();
         Select cboOptions = new Select(lstSearchBy);
		cboOptions.selectByVisibleText("first name");

		txtSearchTerm.clear();
		txtSearchTerm.sendKeys(c.getFirstName());

		this.resultTable = new MyConnectionsResultTable(tabel); 
        return this;
	}


	public void searchConnectionsByFirstName(String firstname) {
		btnConnections.click();

		Select cboOptions = new Select(lstSearchBy);
		cboOptions.selectByVisibleText("first name");

		txtSearchTerm.clear();
		txtSearchTerm.sendKeys(firstname);
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(60));
		this.resultTable = new MyConnectionsResultTable(tabel); 
}

	public MyConnectionsResultTable getResultTable() {
		return resultTable;
	}

	public void setResultTable(MyConnectionsResultTable resultTable) {
		this.resultTable = resultTable;
	}

	public WebElement getTabel() {
		return tabel;
	}

	public void setTabel(WebElement tabel) {
		this.tabel = tabel;
	}

	public WebElement getDivMyConnections() {
		return divMyConnections;
	}

	public void setDivMyConnections(WebElement divMyConnections) {
		this.divMyConnections = divMyConnections;
	}






}