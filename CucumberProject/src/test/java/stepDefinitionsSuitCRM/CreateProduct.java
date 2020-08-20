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

public class CreateProduct {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on AlchemyCRM website page using username and password$")
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

	@When("^Create product using information \"(.*)\" and \"(.*)\"$")
	public void createProduct(String productName, String Price) throws Throwable{
		System.out.println("proce:" +Price);
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		//click activities
		WebElement Sales=driver.findElement(By.id("grouptab_5"));
		Actions act = new Actions(driver);
		act.moveToElement(Sales).perform();
		Thread.sleep(10);
		WebElement productbutton=driver.findElement(By.xpath("//a[@id='grouptab_5']//..//li/a[text()='Products']"));
		exe.executeScript("arguments[0].click();",productbutton);
		//click on meeting
		Thread.sleep(10);
		driver.findElement(By.xpath("//a[@id='grouptab_5']//..//li/a[text()='Products']")).click();
		Thread.sleep(3);
		//WebElement meetingTab=driver.findElement(By.xpath("//a[text()='Products']"));
		//act.moveToElement(meetingTab);
		
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[contains(text(),'Create Product')]")));
		//driver.findElement(By.xpath("//a/span[contains(text(),'Create Product')]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='suitepicon suitepicon-action-create']")));
		driver.findElement(By.xpath("//span[@class='suitepicon suitepicon-action-create']")).click();
		Thread.sleep(3);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
		driver.findElement(By.id("name")).sendKeys(productName);
		Thread.sleep(3);/*
		wait.until(ExpectedConditions.elementToBeClickable(By.id("aos_product_category_name")));
		driver.findElement(By.id("aos_product_category_name")).sendKeys(prodCat);*/
		Thread.sleep(3);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("price")));
		driver.findElement(By.id("price")).sendKeys(Price);
		
		driver.findElement(By.id("SAVE")).click();
	}
	
	@Then("^Verify the product creation using \"(.*)\"$")
	public void verifyProduct(String productName) {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='suitepicon suitepicon-action-list']")));
		driver.findElement(By.xpath("//span[@class='suitepicon suitepicon-action-list']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[@field='name']/b/a")));
		String actualProduc=driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[@field='name']/b/a")).getText();
		Assert.assertEquals(productName, actualProduc);
	}
	
	@Then("^close the browser for CRMact3_4$")
	public void closeBrowser() {
		driver.quit();
	}
}

