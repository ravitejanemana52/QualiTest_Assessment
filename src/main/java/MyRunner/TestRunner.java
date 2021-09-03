package MyRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/main/java/Features", //the path of the feature files
			glue={"stepDefinitions"}, //the path of the step definition files
			format= {"pretty","html:target/cucumber-reports", "html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
			monochrome = true,
			strict = true,
			dryRun = false,
			tags = { "@sampleTest"}
			)
	 // "~@RegressionTest", "~@End2End"
	public class TestRunner {
	 
	}

