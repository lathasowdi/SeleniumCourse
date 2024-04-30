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
import org.testng.annotations.BeforeClass;
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
import ctg.automation.pageobjects.StatsPage;
import ctg.automation.pageobjects.StatsTable;


public class TestCaseStatsPage {

	public static WebDriver globalEventDriver;
	public static MenuPage menu= new MenuPage();
	public static LoginPage loginPage= new LoginPage();
	public static WelcomePage welcomePage= new WelcomePage();
	public static AdminPage adminuser= new AdminPage();
	public static NewPage newconnectionpage=new NewPage();
	public static StatsPage statspagee=new StatsPage();
	public static StatsTable statstable=new StatsTable();
	
	@BeforeSuite
	public static void setUP() {
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
	public void verifyTableData() throws InterruptedException {
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
		Connection nc1 = new Connection( "Omshiva","namashivaya","F","bliss@gmail.com","1111/11.22.33","CTG","Testing","Junior","happy");
		
		newconnectionpage.createNewConnectionWith(nc1);
		
		Thread.sleep(3000);
		System.out.println("New connection is added, smile");
Connection nc2 = new Connection( "Omshivaya","namashivaya","F","bliss@gmail.com","1111/11.22.33","CTG","AS","Senior","happy");
		
		newconnectionpage.createNewConnectionWith(nc2);
		Thread.sleep(3000);
		System.out.println("New connection is added, smile");
Connection nc3 = new Connection( "Omshivaom","namashivaya","F","bliss@gmail.com","1111/11.22.33","CTG","ITSM","Experienced","happy");
		
		newconnectionpage.createNewConnectionWith(nc3);
		Thread.sleep(3000);
		System.out.println("New connection is added, smile");
		
		menu.OpenStatsPagepf();
		System.out.println("Row count: " + statstable.getRowCount());

		//statstable.printTableData();

		System.out.println("Data in row 1 & col 1 : " + statstable.getText(1, 1).toString());
		System.out.println("Data in row 1 & col 2 : " + statstable.getText(1, 2).toString());
		System.out.println("Data in row 1 & col 3 : " + statstable.getText(1, 3).toString());
		System.out.println("Data in row 2 & col 1 : " + statstable.getText(2, 1).toString());
		System.out.println("Data in row 2 & col 2 : " + statstable.getText(2, 2).toString());
		System.out.println("Data in row 2 & col 3 : " + statstable.getText(2, 3).toString());
		System.out.println("Data in row 3 & col 1 : " + statstable.getText(3, 1).toString());
		System.out.println("Data in row 3 & col 2 : " + statstable.getText(3, 2).toString());
		System.out.println("Data in row 3 & col 3 : " + statstable.getText(3, 3).toString());
		System.out.println("Data in row 4 & col 1 : " + statstable.getText(4, 1).toString());
		System.out.println("Data in row 4 & col 1 : " + statstable.getText(4, 2).toString());
		System.out.println("Data in row 4 & col 1 : " + statstable.getText(4, 3).toString());

		if(statstable.getText(1, 1).equals("Total connections") && statstable.getText(1, 3).toString().equals("3")) {
			System.out.println("The total number of connections is correct");		
		} else 
		{
			System.out.println("The total number of connections is not correct");
		}


	}

@AfterSuite
public static void tearDown(){
	
	DriverManager.quitDriver();
	
}
}



