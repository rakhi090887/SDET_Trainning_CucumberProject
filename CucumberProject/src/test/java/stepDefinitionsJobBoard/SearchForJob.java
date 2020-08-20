package stepDefinitionsJobBoard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class SearchForJob {
	WebDriver driver;
	WebDriverWait wait;


	@Given("^user is on alchemyJob Site$")
	public void userOnAlchemyJob() throws Throwable{
		//Launch the browser
		driver= new FirefoxDriver();
		wait=new WebDriverWait(driver, 10);
		//Navigate to the JobBoard Page
		driver.get("https://alchemy.hguy.co/jobs/");
	}

	@When("^verify user is on Alchemy Job Page$")
	public void verifyJobPageTitle() {

		//Verify the page is dispayed with title
		String joboard_jobPagetitle="Alchemy Jobs – Job Board Application";
		Assert.assertEquals(joboard_jobPagetitle, driver.getTitle());

	}

	@Then("^Navigate to Jobs page and search for job with fulltime Filteration$")
	public void navigateToJobPage() throws Throwable{

		//click on Job button
		driver.findElement(By.xpath("//li[@id='menu-item-24']//a[contains(text(),'Jobs')]")).click();

		//search for Keyword
		driver.findElement(By.id("search_keywords")).sendKeys("Automation Tester");

		Thread.sleep(10);
		//Change Job type
		if(driver.findElement(By.id("job_type_freelance")).isSelected()) {
			driver.findElement(By.id("job_type_freelance")).click();
		}
		if(driver.findElement(By.id("job_type_full-time")).isSelected()) {
			driver.findElement(By.id("job_type_full-time")).click();
		}
		if(driver.findElement(By.id("job_type_internship")).isSelected()) {
			driver.findElement(By.id("job_type_internship")).click();
		}
		if(driver.findElement(By.id("job_type_part-time")).isSelected()) {
			driver.findElement(By.id("job_type_part-time")).click();
		}
		if(driver.findElement(By.id("job_type_temporary")).isSelected()) {
			driver.findElement(By.id("job_type_temporary")).click();
		}

		driver.findElement(By.xpath("//input[@id='job_type_full-time']")).click();
		Thread.sleep(10);
		driver.findElement(By.xpath("//input[@value='Search Jobs'][@type='submit']")).click();
		Thread.sleep(10);
	}

	@Then("^print the job title and click for apply for job$")
	public void printtitleandapplyJob() throws Throwable{
		//job listing
		List<WebElement> jobListing=driver.findElements(By.xpath("//ul[@class='job_listings']/li"));
		System.out.println("count of Job: "+jobListing.size());
		Thread.sleep(10);
		for(WebElement jobs : jobListing) {
			System.out.println(jobs.findElement(By.xpath("//li//div[@class='position']/h3")).getText());
			jobs.findElement(By.xpath("//li//div[@class='position']/h3")).click();
			//appy job
			driver.findElement(By.xpath("//input[@class='application_button button']")).click();

		}
	}

	@Then("^close the browser for Activity2$")
	public void closeBrowser() {
		driver.close();
	}



}
