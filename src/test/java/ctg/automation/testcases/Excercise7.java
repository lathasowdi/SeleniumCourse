
package ctg.automation.testcases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.Select;

import ctg.automation.pageobjects.AdminPage;
import ctg.automation.pageobjects.LoginPage;
import ctg.automation.pageobjects.MenuPage;
import ctg.automation.pageobjects.URLManager;
import ctg.automation.pageobjects.WelcomePage;


public class Excercise7 {
	

	public static WebDriver globalEventDriver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//DriverManager.setFireFoxDriver();
		
		WebDriver normalDriver=DriverManager.getDriver();
		WebDriverListener listener= new CustomListener();
		globalEventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
		final	WebDriver eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
				
		URLManager.GoToApplication();
		MenuPage menu= new MenuPage();
		LoginPage loginPage= new LoginPage();
		WelcomePage welcomePage= new WelcomePage();
		AdminPage adminuser= new AdminPage();
		
		
		PageFactory.initElements(eventDriver, menu);
		PageFactory.initElements(eventDriver, loginPage);
		PageFactory.initElements(eventDriver, welcomePage);
		PageFactory.initElements(eventDriver, adminuser);
		menu.logOut();
		Thread.sleep(3000);
		loginPage.setLanguageTo("French");
		loginPage.loginWith("admin", "superduper");
		Thread.sleep(3000);
		menu.btnAdminClick();
		
		String currentWindow =eventDriver.getWindowHandle();
		
		Set<String> allWindows= eventDriver.getWindowHandles();
		String newWindow=null;
		for(String window:allWindows) {
			if(!currentWindow.equals(window)) {
				newWindow=window;
				break;
			}}
		eventDriver.switchTo().window(newWindow);
		Thread.sleep(3000);
		adminuser.btnRestUsersClick();
		Thread.sleep(3000);
		verifyPopUpText();
		adminuser.acceptPopUp();
		
		Thread.sleep(3000);
		adminuser.createNewUser("joy"," bliss");
		
		
		eventDriver.switchTo().window(currentWindow);
		
		menu.logOut();
		Thread.sleep(3000);
		loginPage.loginWith("joy"," bliss");
		Thread.sleep(3000);
		
		if(welcomePage.getWelcomeMessage().contains("Welcome"))
		{
			
			System.out.println("Welcome message is correct");
		}
		
	DriverManager.quitDriver();

}
	
	public static void verifyPopUpText() {
		
		String text = globalEventDriver.switchTo().alert().getText();
		if(text.equalsIgnoreCase("Users reset.")) {
			System.out.println("Alert message is correct");
		}	}

}


