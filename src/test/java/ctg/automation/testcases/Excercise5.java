package ctg.automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ctg.automation.pageobjects.LoginPage;
import ctg.automation.pageobjects.MenuPage;
import ctg.automation.pageobjects.URLManager;
import ctg.automation.pageobjects.WelcomePage;


public class Excercise5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DriverManager.setFireFoxDriver();
				
		URLManager.GoToApplication();
				MenuPage menu= new MenuPage();
				LoginPage loginPage= new LoginPage();
				WelcomePage welcomePage= new WelcomePage();
				
				
				PageFactory.initElements(DriverManager.getDriver(), menu);
				PageFactory.initElements(DriverManager.getDriver(), loginPage);
				PageFactory.initElements(DriverManager.getDriver(), welcomePage);
				
				menu.logOut();
				loginPage.setLanguageTo("French");
				loginPage.loginWith("admin", "superduper");
				
				
				if(welcomePage.getWelcomeMessage().contains("Welcome"))
				{
					
					System.out.println("Welcome message is correct");
				}
				
				
				
				
				DriverManager.quitDriver();


	}

}
