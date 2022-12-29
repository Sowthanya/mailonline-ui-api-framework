package com.mailonline.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/com/mailonline/api/features",
		glue = {"com.mailonline.api.steps","com.mailonline.utils"}
		)

public class TestRunnerAPI extends AbstractTestNGCucumberTests {	
}
