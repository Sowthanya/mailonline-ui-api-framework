package com.mailonline.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/com/mailonline/ui/features",
		glue = {"com.mailonline.ui.steps","com.mailonline.utils"}
		)

public class TestRunnerUI extends AbstractTestNGCucumberTests {	
}
