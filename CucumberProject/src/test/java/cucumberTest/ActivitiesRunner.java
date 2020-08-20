package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="FeatureJobBoard",
		glue= {"stepDefinitionsJobBoard"},
		tags= {"@activity1_1"},
		strict=true
		
		)
public class ActivitiesRunner {}
