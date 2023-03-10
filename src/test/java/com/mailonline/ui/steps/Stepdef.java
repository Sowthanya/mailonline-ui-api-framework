package com.mailonline.ui.steps;

import java.time.Duration;
import java.util.Calendar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.mailonline.pages.HomePage;
import com.mailonline.pages.SportPage;
import com.mailonline.utils.Action;
import com.mailonline.utils.Constants;
import com.mailonline.utils.DriverManager;
import com.mailonline.utils.GenericUtils;
import com.mailonline.utils.ReportUtil;

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
		    			
		homePage.launchAppURL(Constants.APPURL);
		Reporter.log("Application Launched");
	}	
	
	@When("I am on the home page")
	public void verifyHomePage()
	{
		String homePageName = homePage.getHomePageName();
		Assert.assertEquals(homePageName, "Home", "Home Page name : " + homePageName);	
		Reporter.log("Home page is displayed successfully");
	}
	
	@Then("I should see the current date and Time in the home page")
	public void dateVerification()
	{
		Calendar cal = Calendar.getInstance();
		String dateInHomePage = homePage.getDateTimeFromHomePage();
		String currentDate = GenericUtils.getDateInRequiredFormat(cal);
		Reporter.log("Expected Date and Time: " + currentDate);
		Reporter.log("Actual Date and Time: " + dateInHomePage);
		Assert.assertEquals(dateInHomePage,currentDate);
		Reporter.log("Current Date and Time in the Home page is verified successfully");
		
	}

	@And("^I navigate to \"(.*)\" from \"(.*)\" menu$")
	public void navigateToSecondaryMenu(String secondary, String primary)
	{
		homePage.getPrimaryNavMenuItem(primary).click();
		Reporter.log("Clicked on the " + primary + "page");		
		homePage.getSecondaryNavMenuItem(secondary).click();
		Reporter.log("Navigated to the " + secondary + "page");		
	}
	
	@When("^I click on the \"(.*)\" primary navigation$")
	public void primaryNavigation(String menuPrimary)
	{
		homePage.getPrimaryNavMenuItem(menuPrimary).click();
		Reporter.log("Clicked on the " + menuPrimary + "page");	
	}
	
	@Then("I should see both primary and secondary navigations are same in colour")
	public void menuColourValidation()
	{
		String primaryNavColour = homePage.getPrimaryNavBackgroundColour();
		String secondaryNavColour = homePage.getSecondaryNavBackgroundColour();
		Assert.assertEquals(primaryNavColour, secondaryNavColour);
		Reporter.log("Primary and Secondary navigation menu item colurs are same");
	}
	
	@When("I open the first article")
	public void openArticle()
	{
		sportPage.openFirstSportsArticle();
		Reporter.log("First Article in the sports section is opened");
	}
	
	@And("^I Open the image gallery on full screen$")
	public void openImageGallery()
	{
		sportPage.openImageGallery();
		Reporter.log("Image gallery on the First sports article is opened");
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
    	Reporter.log("Previous Button is displyed in Gallery full view");
    	Assert.assertTrue(sportPage.getGalleryNextButton().isDisplayed());
    	Reporter.log("Next Button is displyed in Gallery full view");
    	Assert.assertEquals(!sportPage.getGalleryPrevButton().isEnabled(), true);
    	Reporter.log("Previous Button is disbled by default in Gallery full view on the first image");
    	Assert.assertEquals(sportPage.getImageNumber(), 1);
     	Reporter.log("Image counter is displayed correctly on the first image");
    	sportPage.getGalleryNextButton().click();  
    	Assert.assertEquals(sportPage.getImageNumber(), 2);
    	Reporter.log("Image counter is incremented correctly on clicking next button");
    	sportPage.getGalleryPrevButton().click();
    	Assert.assertEquals(sportPage.getImageNumber(), 1);
    	Reporter.log("Image counter is decremented correctly when clicked on previous button");
    	}
    
    @When("^I click on the facebook icon in the image gallery$")
    public void openGalleryNavigation()
    {	
        sportPage.openSocialMedia();
        Reporter.log("Social media container is displayed correctly ");
    }    
    @Then("^I verify the \"(.*)\" modal dialog is opened$")
    public void verifyFacebookModal(String handleName)
    {      
    	String windowTitle = sportPage.verifyFacebookDialog(handleName);   	
    	Reporter.log("Facebook icon is clicked");
    	Assert.assertEquals(windowTitle.contains("Facebook"),true);
    	Reporter.log("Facebook Login page opened successfully");
    }
    @Then("^I display the details of the \"(.*)\" team from premier league table$")
    public void premierLeagueTableDetails(String teamName)
    {
    	sportPage.displayPremierLeagueDetails(teamName);
    	Reporter.log("Premier League details of the team: " + teamName);
    	Reporter.log(ReportUtil.generateHTMLTable(teamName, sportPage.getTeamPosition(teamName).getText(), sportPage.getTeamPoints(teamName).getText()));
    }
    
}