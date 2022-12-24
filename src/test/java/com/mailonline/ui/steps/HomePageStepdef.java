package com.mailonline.ui.steps;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mailonline.pages.HomePage;
import com.mailonline.utils.DriverManager;
import com.mailonline.utils.GenericUtils;

import io.cucumber.java.en.And;
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
		String dateInHomePage = homePage.getDateTimeFromHomePage();
		String currentDate = GenericUtils.getDateInRequiredFormat(cal);
		Assert.assertEquals(dateInHomePage,currentDate);
		
	}

	@And("^I navigate to \"(.*)\" from \"(.*)\" menu$")
	public void navigateToSecondaryMenu(String primary, String secondary)
	{
		driver.findElement(By.xpath("//div[contains(@class,'page-header')]//li[@class='sport']")).click();
	    driver.findElement(By.xpath("//div[@class='sport nav-secondary-container']//li/a[text()='Football']")).click();
	}
	
	//div[@data-track-module='football-desktop-ap-triple_article_headline']
	 
}