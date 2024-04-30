package ctg.automation.pageobjects;

import org.junit.Assert;

import java.util.Set;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import ctg.automation.helpers.CustomListener;

public class Exercise11 {
	
public static WebDriver globalEventDriver;
public static MenuPage menu= new MenuPage();
public static LoginPage loginPage= new LoginPage();
public static WelcomePage welcomePage= new WelcomePage();
public static AdminPage adminuser= new AdminPage();

@BeforeAll
public static void setUp(){
	WebDriver normalDriver=DriverManager.getDriver();
	WebDriverListener listener= new CustomListener();
	globalEventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
	final	WebDriver eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
			
	URLManager.GoToApplication();
	
	PageFactory.initElements(eventDriver, menu);
	PageFactory.initElements(eventDriver, loginPage);
	
}
@ParameterizedTest
@CsvSource({
	"admin,wrong,the password is incorrect please enter correct password",
	"wrong,superduper,theusername is incorrect please enter correct password",
	",,, please enter username and password"
})


public void loggingWithCorrectUsernameAndPassword(String username,String password, String errormessage) throws InterruptedException{
	
	if(username==null)
	{
		username="";
	}
	if(password==null)
	{
		password="";
	}
	menu.logOut();
	loginPage.loginWith(username, password);
	System.out.println(errormessage);
	
}

@AfterAll
public static void tearDown(){
	
	DriverManager.quitDriver();
	
}



}

