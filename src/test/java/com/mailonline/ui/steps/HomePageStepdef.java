package com.mailonline.ui.steps;

import org.openqa.selenium.WebDriver;
import com.mailonline.pages.HomePage;
import com.mailonline.utils.DriverManager;
import io.cucumber.java.en.Given;

public class HomePageStepdef{
	
	WebDriver driver;
	public HomePageStepdef(DriverManager driverManager)
	{
		this.driver = driverManager.getDriver();
	}
	
	@Given("I launch the application")
	public void launchApplication()	{
		    HomePage homePage = new HomePage(driver);			
		    homePage.launchAppURL("https://www.bigbasket.com/");
	}	
}