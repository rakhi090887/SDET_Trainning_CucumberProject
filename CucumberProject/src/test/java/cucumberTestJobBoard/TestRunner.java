package cucumberTestJobBoard;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/FeaturesJobBoard",
		glue= {"stepDefinitionsJobBoard"},
		tags= {"@activity1_1,@activity1_2,@activity1_3,@activity1_4"},
		strict=true,
		plugin= {"pretty", "html:target/test_reports_JobBoard", "json:testJson_Reports_JobBoard"},
		monochrome=true
		
		
		)
public class TestRunner {}
