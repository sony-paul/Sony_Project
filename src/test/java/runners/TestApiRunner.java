package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features="src/test/resources/Features/api.feature",
	glue={"StepDefinitions"},
	monochrome=true,
	publish = true,
	plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	)

public class TestApiRunner extends AbstractTestNGCucumberTests {
	
	}
