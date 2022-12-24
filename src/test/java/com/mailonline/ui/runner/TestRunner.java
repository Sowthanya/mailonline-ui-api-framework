package com.mailonline.ui.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/com/mailonline/ui/features/HomePage.feature",
		glue = "com.mailonline.ui.steps"
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	

}
