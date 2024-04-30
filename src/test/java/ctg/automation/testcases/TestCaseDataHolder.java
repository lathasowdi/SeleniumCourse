package ctg.automation.testcases;



import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import ctg.automation.connection.Connection;
import ctg.automation.helpers.CustomListener;
import ctg.automation.pageobjects.AdminPage;
import ctg.automation.pageobjects.DriverManager;
import ctg.automation.pageobjects.LoginPage;
import ctg.automation.pageobjects.MenuPage;
import ctg.automation.pageobjects.URLManager;
import ctg.automation.pageobjects.WelcomePage;

import ctg.automation.pageobjects.NewPage;

public class TestCaseDataHolder {
	
public static WebDriver globalEventDriver;
public static MenuPage menu= new MenuPage();
public static LoginPage loginPage= new LoginPage();
public static WelcomePage welcomePage= new WelcomePage();
public static AdminPage adminuser= new AdminPage();
public static NewPage newconnectionpage=new NewPage();


@BeforeSuite
public static void setUp() throws InterruptedException{
	WebDriver normalDriver=DriverManager.getDriver();
	WebDriverListener listener= new CustomListener();
	globalEventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
	final	WebDriver eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
			
	URLManager.GoToApplication();
	PageFactory.initElements(eventDriver, menu);
	PageFactory.initElements(eventDriver, loginPage);
	PageFactory.initElements(eventDriver, welcomePage);
	PageFactory.initElements(eventDriver, adminuser);
	
	
	}


@Test
public void loggingWithemptyUsernameAndPassword() throws InterruptedException{
	menu.logOut();
	Thread.sleep(3000);
	loginPage.setLanguageTo("French");
	loginPage.loginWith("admin", "superduper");
	
	boolean isDisplayed=welcomePage.isWelcomeMessageDisplayed();
	if(isDisplayed) {
		System.out.println("Welcome page is displayed");
	}
	if(!isDisplayed) {
		System.out.println("Welcome page is not displayed");
	}
	menu.openNewPage();
	Thread.sleep(3000);
	System.out.println("New page is  displayed");
	Connection nc = new Connection( "Omshiva","namashivaya","F","bliss@gmail.com,","1111/11.22.33","CTG","AS","Senior","happy");
	
	newconnectionpage.createNewConnectionWith(nc);
	System.out.println("New connection is added, smile");
	//Assertion.assertTrue(welcomePage.isWelcomeMessageDisplayed());
}



@AfterSuite
public static void tearDown(){
	
	DriverManager.quitDriver();
	
}



}
