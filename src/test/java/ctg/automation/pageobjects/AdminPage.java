
package ctg.automation.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminPage {
	
	
	
	@FindBy(how= How.XPATH, using="//label[contains(text(),'reset users')]")
	private WebElement btnRestUsers;
	
	@FindBy(how= How.XPATH, using="//input[@id='new_username']")
	private WebElement txtUserName;
	
	
	@FindBy(how= How.XPATH, using="//input[@id='new_password']")
	private WebElement txtPassword;
	
	@FindBy(how= How.XPATH, using="//span[contains(text(),'create')]")
	private WebElement btnCreate;
	@FindBy(xpath = "//label[contains(text(),'reset connections')]")
	private WebElement resetConnectionsButton;
	
	@FindBy(xpath = "//label[contains(text(),'populate records')]")
	private WebElement populateButton;
	
	
	
	public void btnRestUsersClick() {
		btnRestUsers.click();
		}
	
	public void createNewUser(String username, String password) {
		txtUserName.clear();
		txtUserName.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		btnCreate.click();
			}
	
	public void acceptPopUp() {
		
	DriverManager.getDriver().switchTo().alert().accept();
		}
	public void populateForTesting() {
		populateButton.click();
		Alert alert = DriverManager.getDriver().switchTo().alert();
		alert.accept();
		System.out.println("RECORDS WERE POPULATED");
	}
	
	public void resetConnections() {
		resetConnectionsButton.click();
		Alert alert = DriverManager.getDriver().switchTo().alert();
		alert.accept();
		System.out.println("CONNECTIONS RESETED");
	}
}