package stepDefinitionsSuitCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class ScheduleMeeting {

	WebDriver driver;
	WebDriverWait wait;


	@Given("^User is logged in on alchemy CRM page$")
	public void userInLoginPage() {

		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();

		//Launch the application
		driver.get("https://alchemy.hguy.co/crm/index.php");

		driver.findElement(By.id("user_name")).sendKeys("admin");

		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");

		driver.findElement(By.id("bigbutton")).click();
	}

	@When("^Navigate to schedule meeting and search for page$")
	public void navigateToMeeting() throws Throwable{

		//click activities
		WebElement Sales=driver.findElement(By.id("grouptab_3"));
		Actions act = new Actions(driver);
		act.moveToElement(Sales).perform();
		WebElement meetingbutton=driver.findElement(By.xpath("//a[@id='grouptab_3']//..//li/a[text()='Meetings']"));
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click();",meetingbutton);
		//click on meeting
		Thread.sleep(10);
		driver.findElement(By.xpath("//a[@id='grouptab_3']//..//li/a[text()='Meetings']")).click();
		Thread.sleep(3);
		WebElement meetingTab=driver.findElement(By.xpath("//a[text()='Meetings']"));
		act.moveToElement(meetingTab);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-action-name='Schedule_Meeting']")));
		driver.findElement(By.xpath("//a[@data-action-name='Schedule_Meeting']")).click();
		wait.until(ExpectedConditions.elementToBeClickable((By.id("name"))));
		driver.findElement(By.id("name")).sendKeys("Testting");
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//input[@id='date_start_date']"))));
		driver.findElement(By.xpath("//input[@id='date_start_date']")).sendKeys("08/19/2020");
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//input[@id='date_end_date']"))));
		driver.findElement(By.xpath("//input[@id='date_end_date']")).sendKeys("08/19/2020");
		Thread.sleep(5);
	}
	
	@Then("^add member \"(.*)\" and \"(.*)\"$")
	public void addMember(String first, String last) throws Throwable{
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search_first_name']")));
		driver.findElement(By.xpath("//input[@id='search_first_name']")).sendKeys(first);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search_last_name']")));
		driver.findElement(By.xpath("//input[@id='search_last_name']")).sendKeys(last);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='invitees_search']")));
		driver.findElement(By.xpath("//input[@id='invitees_search']")).click();
		Thread.sleep(5);
		//add
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='list view']//tr[2]/td[input[@id='invitees_add_1']]")));
		driver.findElement(By.xpath("//table[@class='list view']//tr[2]/td[input[@id='invitees_add_1']]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='buttons']//input[@id='SAVE_HEADER']")));
		driver.findElement(By.xpath("//td[@class='buttons']//input[@id='SAVE_HEADER']")).click();
	}
	
	@Then("^verify the meeting created \"(.*)\"$")
	public void verfifyMeetng(String meeting) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'View Meetings')]")));
		driver.findElement(By.xpath("//div[contains(text(),'View Meetings')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[@type='name']/b/a")));
		String meetingName=driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[@type='name']/b/a")).getText();
		System.out.println(meetingName);
		
		Assert.assertEquals(meetingName, meeting);
		
	}
	
	@Then("^close the browser for CRMAc3_3$")
	public void closeBrowser() {
		driver.quit();
	}

}
