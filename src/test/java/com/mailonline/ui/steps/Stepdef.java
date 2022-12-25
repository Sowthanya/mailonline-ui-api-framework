package com.mailonline.ui.steps;

import java.util.Calendar;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.mailonline.pages.HomePage;
import com.mailonline.pages.SportPage;
import com.mailonline.utils.DriverManager;
import com.mailonline.utils.GenericUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdef{
	
	WebDriver driver;
	HomePage homePage;
	SportPage sportPage;
	
	public Stepdef(DriverManager driverManager)
	{
		this.driver = driverManager.getDriver();
		homePage = new HomePage(driver);	
		sportPage = new SportPage(driver);	
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
	public void navigateToSecondaryMenu(String secondary, String primary)
	{
		homePage.getPrimaryNavMenuItem(primary).click();
		homePage.getSecondaryNavMenuItem(secondary).click();
	}
	
	@When("^I click on the \"(.*)\" primary navigation$")
	public void primaryNavigation(String menuPrimary)
	{
		homePage.getPrimaryNavMenuItem(menuPrimary).click();
	}
	
	@Then("I should see both primary and secondary navigations are same in colour")
	public void menuColourValidation()
	{
		String primaryNavColour = homePage.getPrimaryNavBackgroundColour();
		String secondaryNavColour = homePage.getSecondaryNavBackgroundColour();
		Assert.assertEquals(primaryNavColour, secondaryNavColour);
	}
	@When("I open the first article")
	public void openArticle()
	{
		sportPage.openFirstSportsArticle();
	}
	
	@And("^I Open the image gallery on full screen$")
	public void openImageGallery()
	{
		sportPage.openImageGallery();
	}
	
    @Then("I verify the arrow icons are working as expected")
    /*
     * 1.Verify Prev and Next buttons are displayed
     * 2.The Prev button is disabled when we are on the first image     
     * 3.The image counter label is incremented/decremented when we navigate next and prev     
     */
    public void verifyImageGalleryNavigations()
    {
    	Assert.assertTrue(sportPage.getGalleryPrevButton().isDisplayed());
    	Assert.assertTrue(sportPage.getGalleryNextButton().isDisplayed());
    	Assert.assertEquals(!sportPage.getGalleryPrevButton().isEnabled(), true);
    	Assert.assertEquals(sportPage.getImageNumber(), 1);
    	sportPage.getGalleryNextButton().click();  
    	Assert.assertEquals(sportPage.getImageNumber(), 2);
    	sportPage.getGalleryPrevButton().click();
    	Assert.assertEquals(sportPage.getImageNumber(), 1);
    }	 
}