package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {
	WebDriver driver;
	WebDriverWait wait;
	
@Given("^User is on Google Home Page$")
public void userOnGooglePage() {
	driver=new FirefoxDriver();
	wait=new WebDriverWait(driver, 15);
	
	//Open Google home page
	driver.get("https://www.google.com/");
	
	//Get the title of google home page
	String homePageTitle="Google";
	Assert.assertEquals(homePageTitle, driver.getTitle());
}

@When("^User types in Cheese and hits ENTER$")
public void userTypesCheeseAndhitsEnter() {
	driver.findElement(By.name("q")).sendKeys("Cheese",Keys.ENTER);
}

@Then("^Show how many search results were shown$")
public void showResultsCount() {
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("result-stats")));
	String resultcount=driver.findElement(By.id("result-stats")).getText();
	System.out.println(" Cheese result count: "+resultcount);
}

@And("^Close the browser$")
public void closeBrowser() {
	driver.close();
}
}
