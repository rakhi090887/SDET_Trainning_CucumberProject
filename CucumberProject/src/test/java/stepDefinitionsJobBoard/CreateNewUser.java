package stepDefinitionsJobBoard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class CreateNewUser {
	WebDriver driver;
	WebDriverWait wait;
	
@Given("^user is on to jobboard site$")
public void userOnJobBoardPage() throws Throwable{
	//Launch the browser
	driver= new FirefoxDriver();
	wait=new WebDriverWait(driver, 10);
	//Navigate to the JobBoard Page
	driver.get("https://alchemy.hguy.co/jobs/wp-login.php");
	
	//Verify the page is dispayed with title
	String joboard_LoginPagetitle="Log In ‹ Alchemy Jobs — WordPress";
	Assert.assertEquals(joboard_LoginPagetitle, driver.getTitle());
	
}

@When("^user logs in with \"(.*)\" and \"(.*)\"$")
public void userLogin(String username, String password) throws Throwable{
	
	driver.findElement(By.id("user_login")).sendKeys(username);
	driver.findElement(By.id("user_pass")).sendKeys(password);
	
	driver.findElement(By.id("wp-submit")).click();
	
	
}

@Then("^user is on jobboard home page$")
public void verifyHomePage() throws Throwable{
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Users')]")));
	String homePageTitle="Dashboard ‹ Alchemy Jobs — WordPress";
	
	Assert.assertEquals(homePageTitle, driver.getTitle());
}

@Then("^Click on Add new user and Verify user is created$")
public void CreateNewUser() throws Throwable{
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Users')]")));
	driver.findElement(By.xpath("//div[contains(text(),'Users')]")).click();
	//click on add new user button
	driver.findElement(By.xpath("//a[@class='page-title-action']")).click();
	
	//fill the form
	driver.findElement(By.id("user_login")).sendKeys("Rakhi123");
	driver.findElement(By.id("email")).sendKeys("rakhi123@gmail.com");
	driver.findElement(By.id("first_name")).sendKeys("Rakhi");
	driver.findElement(By.id("last_name")).sendKeys("Maheshwari");
	driver.findElement(By.xpath("//button[@class='button wp-generate-pw hide-if-no-js']")).click();
	//driver.findElement(By.xpath("//input[@id='pass1']")).clear();
	//Thread.sleep(5000);
	//driver.findElement(By.xpath("//input[@id='pass1']")).sendKeys("pa$");
	//Submit the button
	driver.findElement(By.id("createusersub")).click();
	
	//Verifyt he user is created
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-search-input")));
	driver.findElement(By.id("user-search-input")).sendKeys("Rakhi1234");
	driver.findElement(By.id("search-submit")).click();
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='wp-list-table widefat fixed striped users']")));
	
	String username = driver.findElement(By.xpath("//tbody[@id='the-list']/tr[1]/td[@data-colname='Username']")).getText();
	System.out.println();
	
	Assert.assertEquals(username, "Rakhi123");
}

@Then("^close the browser for activity1$")
public void closeBrowser() {
	driver.close();
}

}
