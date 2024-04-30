package ctg.automation.pageobjects;

public class URLManager {
	
	public static void GoToApplication() {
		DriverManager.getDriver().get("https://app-tst-training.azurewebsites.net/");
		DriverManager.getDriver().manage().window().maximize();
		System.out.println("Navigate to website");
		
	}
	

}
