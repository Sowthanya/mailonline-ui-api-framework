package com.mailonline.ui.steps;

import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mailonline.pages.HomePage;
import com.mailonline.utils.DriverManager;
import com.mailonline.utils.GenericUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepdef{
	
	WebDriver driver;
	HomePage homePage;
	
	public HomePageStepdef(DriverManager driverManager)
	{
		this.driver = driverManager.getDriver();
		homePage = new HomePage(driver);		
	}
	
	@Given("I launch the application")
	public void launchApplication()	{
		    			
		homePage.launchAppURL("https://www.dailymail.co.uk/home/index.html");
	}	
	
	@When("I am on the home page")
	public void verifyHomePage()
	{
		String homePageName = homePage.getHomePageName();
		Assert.assertEquals(homePageName, "Home", "Home Page name : " + homePageName);
	}
	
	@Then("I should see the current date and Time in the home page")
	public void dateVerification()
	{
		Calendar cal = Calendar.getInstance();
		String dateInHomePage = homePage.getDateFromHomePage();
		String currentDate = GenericUtils.getDateInRequiredFormat(cal);
		Assert.assertEquals(dateInHomePage,currentDate);
		
	}
}