package StepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features="src/test/resources/Features",
	glue={"StepDefinitions"},
	tags= "@deckofcardsapi",
	monochrome=true,
	publish = true,
	dryRun=false,
	plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	}
