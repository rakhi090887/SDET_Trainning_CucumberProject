package stepDefinitionsJobBoard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class PostingJobUsingExampleTable {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on Alchemy WebSites$")
	public void userInAlchemywebsite() {

		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver, 5);
		driver.get("https://alchemy.hguy.co/jobs/");

		driver.manage().window().maximize();


		String  pageTitle="Alchemy Jobs – Job Board Application";

		Assert.assertEquals(pageTitle, driver.getTitle());
	}
	
	@When("^Navigate to Post JobPage$")
	public void navigateToPostJobPage() {
		
		driver.findElement(By.xpath("//a[text()='Post a Job']")).click();


		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");

		driver.findElement(By.id("wp-submit")).click();

	}
	
	@Then("^Fill the form using \"(.*)\",\"(.*)\",\"(.*)\" and \"(.*)\".$")
	public void fillTheJobForm(String jobTitle, String jobLocation,String jobType, String job_desc) {
		
		//enter the title
				driver.findElement(By.id("job_title")).sendKeys(jobTitle);
				driver.findElement(By.id("job_location")).sendKeys(jobLocation);

				Select sl = new Select(driver.findElement(By.id("job_type")));
				sl.selectByVisibleText(jobType);

				driver.switchTo().frame("job_description_ifr");

				driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys(job_desc);
				
				driver.switchTo().defaultContent();
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name("submit_job")));

				driver.findElement(By.name("submit_job")).click();

				driver.findElement(By.id("job_preview_submit_button")).click();
	}
	
	@Then("^Verify job is listed in listing on jobPage.$")
	public void verifyJobList() {
		//Verify the job is submitted
		String verifyMsg=driver.findElement(By.xpath("//div[@class='entry-content clear']")).getText();

		if(verifyMsg.contains("Job submitted successfully")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	@Then("^close the browser for activity4$")
	public void closeBrowser() {
		driver.close();
	}
}
