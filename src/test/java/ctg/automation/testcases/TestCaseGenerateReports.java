package ctg.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ctg.automation.pageobjects.AdminPage;
import ctg.automation.pageobjects.DriverManager;
import ctg.automation.pageobjects.LoginPage;
import ctg.automation.pageobjects.MenuPage;
import ctg.automation.pageobjects.URLManager;
import ctg.automation.pageobjects.WelcomePage;

public class TestCaseGenerateReports  {
	public static WebDriver driver;
	public static MenuPage menu= new MenuPage();
	public static LoginPage loginPage= new LoginPage();
	public static WelcomePage welcomePage= new WelcomePage();
	public static AdminPage adminuser= new AdminPage();
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	
	@BeforeSuite
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/lkumarasamy/Selenium/drivers/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://app-tst-training.azurewebsites.net/");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, menu);
		PageFactory.initElements(driver, loginPage);
		PageFactory.initElements(driver, welcomePage);
		PageFactory.initElements(driver, adminuser);
		String path = System.getProperty("user.dir") + "\\reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		

		reporter.config(
				ExtentSparkReporterConfig.builder()
				.theme(Theme.STANDARD)
				.documentTitle("RegressionTestReport")
				.build()
				);
		extentTest = extent.createTest("Test Suite");
		
		
}

	@Test(testName = "test1")
	public void loggingWithCorrectUsernameAndPassword() throws InterruptedException{
		extentTest = extent.createTest("Login with Correct Username and Password");
		menu.logOut();
		Thread.sleep(3000);
		loginPage.setLanguageTo("French");
		loginPage.loginWith("admin", "superduper");
		Thread.sleep(3000);
		extentTest.log(Status.PASS, "Login successful");
		System.out.println("Test1 Success");
		//Assertion.assertTrue(welcomePage.isWelcomeMessageDisplayed());
		
	}


	@Test(testName = "test2")
	public void loggingWithCorrectUsernameAndIncorrectPassword() {
		extentTest = extent.createTest("Login with Correct Username and Incorrect Password");
		menu.logOut();
		
		loginPage.setLanguageTo("French");
		loginPage.loginWith("admin", "superdup");
		
		
		System.out.println("Test2 Fail");
		org.testng.Assert.assertFalse(welcomePage.isWelcomeMessageDisplayed());
		extentTest.log(Status.PASS, "Login failed as expected");
	}
	@Test(testName = "test3")
	public void loggingWithIncorrectUsernameAndPassword(){
		menu.logOut();
		
		loginPage.setLanguageTo("French");
		loginPage.loginWith("adn", "superper");
		
		
		System.out.println("Test3 Fail");
		Assert.assertFalse(welcomePage.isWelcomeMessageDisplayed());
	}
	@Test(testName = "test4")
	public void loggingWithemptyUsernameAndPassword(){
		extentTest = extent.createTest("Login with No Username and Password");
		menu.logOut();
		
		loginPage.setLanguageTo("French");
		loginPage.loginWith("", "");
		
		
		System.out.println("Test4 fail");
		//Assertion.assertFalse(welcomePage.isWelcomeMessageDisplayed());
		extentTest.log(Status.PASS, "Login failed as expected");
	}

	@AfterSuite
	public static void tearDown(){
		
		extent.flush();
		
	}



	}
