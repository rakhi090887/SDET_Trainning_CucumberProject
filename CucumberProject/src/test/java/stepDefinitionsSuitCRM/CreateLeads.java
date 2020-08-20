package stepDefinitionsSuitCRM;

import javax.swing.text.Document;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateLeads {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is loggedin on AlchemyCRM WEbsite using \"(.*)\" and \"(.*)\"$")
	public void userLoggedIn(String username, String password) {
	
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();

		//Launch the application
		driver.get("https://alchemy.hguy.co/crm/index.php");

		driver.findElement(By.id("user_name")).sendKeys(username);

		driver.findElement(By.id("username_password")).sendKeys(password);

		driver.findElement(By.id("bigbutton")).click();
	}
	
	@When("^Navigate to leads page and createLeads$")
	public void navigateToLeads() throws Throwable{
		
		//click sales
		WebElement Sales=driver.findElement(By.id("grouptab_0"));
		Actions act = new Actions(driver);
		act.moveToElement(Sales).perform();
		WebElement leadsbutton=driver.findElement(By.xpath("//a[@id='grouptab_0']//..//li/a[text()='Leads']"));
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click();",leadsbutton);
		//click on leads
		Thread.sleep(10);
		//act.moveToElement(driver.findElement(By.xpath("//a[@id='grouptab_0']//..//li/a[text()='Leads']"))).click().perform();
		driver.findElement(By.xpath("//a[@id='grouptab_0']//..//li/a[text()='Leads']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Create Lead']")));
		//click on create leads 
		driver.findElement(By.xpath("//div[text()='Create Lead']")).click();
	}
	
	@Then("^fill the form using Firstname \"(.*)\" and lastName \"(.*)\"$")
	public void createLeads(String firstName, String lastName) throws Throwable{
		wait.until(ExpectedConditions.elementToBeClickable(By.id("first_name")));
		driver.findElement(By.id("first_name")).sendKeys(firstName);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("last_name")));
		driver.findElement(By.id("last_name")).sendKeys(lastName);
		
		//Click on Save
		driver.findElement(By.id("SAVE")).click();
		
		
	}
	
	@Then("^Navigate to view leads to verify leads \"(.*)\"$")
	public void VerifyLeads(String leadsName) {
		
		driver.findElement(By.xpath("//div[text()='View Leads']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'list view table-responsive')]/tbody/tr[1]/td[@type='name']//a")));
		String fullName = driver.findElement(By.xpath("//table[contains(@class,'list view table-responsive')]/tbody/tr[1]/td[@type='name']//a")).getText();
		
		if(fullName.equalsIgnoreCase(leadsName)) {
			Assert.assertTrue(true);
		}
	}
	
	
	@Then("^close the browser for CRMActivity3_2$")
	public void closeTheBrowser() {
		driver.quit();
	}
	

}
