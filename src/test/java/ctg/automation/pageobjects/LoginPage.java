package ctg.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	

	@FindBy(how= How.ID, using="username")
	private WebElement usernameInput;
	
	@FindBy(how= How.ID, using="password")
	private WebElement passwordInput;
	
	@FindBy(how= How.NAME, using="language")
	private WebElement listLanguage;
	
	@FindBy(how= How.XPATH, using="//body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")
	private WebElement btnLogin;
	
	public void loginWith(String username, String password) {
		usernameInput.clear();
		usernameInput.sendKeys(username);
		passwordInput.clear();
		passwordInput.sendKeys(password);
		btnLogin.click();
	}
	
	public String getErrorMessage() {
		return"Please enter correct username and password";
	}
	
	
	public void setLanguageTo(String language) {
		Select setLanguage=new Select(listLanguage);
		setLanguage.selectByVisibleText(language);

	}
	

}
