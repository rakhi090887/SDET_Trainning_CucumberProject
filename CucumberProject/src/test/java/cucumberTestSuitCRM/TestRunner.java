package cucumberTestSuitCRM;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/featureSuitCRM",
		glue= {"stepDefinitionsSuitCRM"},
		tags= {"@CRMFeature"},
		
		strict=true,
		plugin= {"pretty", "html:target/test_reports_CRM", "json:testJson_Reports_CRM"},
		monochrome=true
		
		)
public class TestRunner {}
