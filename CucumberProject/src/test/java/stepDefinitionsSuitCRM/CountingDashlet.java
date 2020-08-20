package stepDefinitionsSuitCRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CountingDashlet {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on Alchemy CRM Page$")
	public void userIsOnalchemyCRMPage() {

		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();

		//Launch the application
		driver.get("https://alchemy.hguy.co/crm/index.php");


	}

	@When("^User logs using \"(.*)\" and \"(.*)\"$")
	public void loginPage(String userName, String password) {

		driver.findElement(By.id("user_name")).sendKeys(userName);

		driver.findElement(By.id("username_password")).sendKeys(password);

		driver.findElement(By.id("bigbutton")).click();
	}

	@Then("^Count the dashlet and print the title.$")
	public void countDashlets() {

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='dashletTable']/tbody//td[contains(@class,'dashletcontainer col-50')]")));
		List<WebElement> dashletscount = driver.findElements(By.xpath("//table[@class='dashletTable']/tbody//td[contains(@class,'dashletcontainer col-50')]//div[contains(@class,'hd dashlet')]"));


		System.out.println("Print the count Dashlets: "+dashletscount.size());

		List<WebElement> coulmDashLet = driver.findElements(By.xpath("//table[@class='dashletTable']/tbody//td[contains(@class,'dashletcontainer col-50')]"));
		System.out.println("coulmn DashLet: "+ coulmDashLet.size());

		for(int i=1;i<=coulmDashLet.size();i++) {
			
			List<WebElement> dashletsTitleCount = driver.findElements(By.xpath("//table[@class='dashletTable']/tbody//td["+i+"][contains(@class,'dashletcontainer col-50')]//li[contains(@id,'dashlet')]"));
			//List<WebElement> dashletsTitleCount = ele.findElements(By.xpath("//li[contains(@id,'dashlet')]"));
			System.out.println("dashletsTitleCount : "+dashletsTitleCount.size());
			for(int j=1;j<=dashletsTitleCount.size();j++) {
				String dashletTitle = driver.findElement(By.xpath("//table[@class='dashletTable']/tbody//td["+i+"][contains(@class,'dashletcontainer col-50')]//li[contains(@id,'dashlet')]["+j+"]//td[@class='dashlet-title']/h3/span[2]")).getText();
				//String dashletTitle = dashlet.findElement(By.xpath("//td[@class='dashlet-title']/h3/span[2]")).getText();

				System.out.println("DashLet Title: "+dashletTitle);
			}
		}
	}
	
	@Then("^close the browser$")
	public void closeBrowser() {
		driver.quit();
	}
}
