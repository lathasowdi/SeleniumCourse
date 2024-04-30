package ctg.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;







public class MenuPage {
	
	@FindBy(how= How.ID, using="logout")
	private WebElement btnLogout;
	
	@FindBy(how= How.XPATH, using="//a[contains(text(),'Admin')]")
	private WebElement btnAdmin;
	 
	@FindBy(id = "crudConnection")			
	private WebElement btnNew;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/ul/li[4]/a")			
	private WebElement btnStats;
	
	@FindBy(xpath = "//a[contains(text(),'Connections')]")			
	private WebElement btnConnections;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/ul/li[1]/a")			
	private WebElement btnHome;
	

	private WebDriver driver;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public MenuPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public void logOut() {
		btnLogout.click();
		}
	
	public void btnAdminClick() {
		btnAdmin.click();
		}
	
    public void openNewPage() {
		
		btnNew.click();
	}
    
    public void openStatsPage() {


		btnStats.click();
	}
    
    public void openConnectionsPage() {


		btnConnections.click();
	}
    public MenuPage OpenConnectionPagepf() {


		btnConnections.click();
		return this;
	}
    public MenuPage OpenStatsPagepf() {


		btnStats.click();
		return this;
	}
    public MenuPage OpenHomePage() {


		btnHome.click();
		return this;
	}
   
}
