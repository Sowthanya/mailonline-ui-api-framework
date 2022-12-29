package com.mailonline.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mailonline.utils.Action;
import com.mailonline.utils.GenericUtils;
import com.mailonline.utils.ReportUtil;

public class SportPage {

	WebDriver driver;

	@FindBy(xpath = "(//div[@class='article article-tri-headline']//h2/a)[1]")
	WebElement sportsCategoryFirstArticleLink;

	@FindBy(xpath = "(//button[contains(@class,'openGalleryButton')]/div[text()='View gallery'])[1]")
	WebElement FirstGalleryButton;

	@FindBy(xpath = "(//ul[contains(@class,'linksHolder')])[1]")
	WebElement mediaLinksHolder;	

	@FindBy(xpath = "//div[contains(@class,'paginationButtons')]/button[@aria-label='Previous']")
	WebElement galleryPrevButton;
	
	@FindBy(xpath = "//div[contains(@class,'paginationButtons')]/button[@aria-label='Next']")
	WebElement galleryNextButton;
	
	@FindBy(xpath="//div[contains(@class,'counter')]")
	WebElement counterLabel;
	
	@FindBy(xpath="//div[@id='header_container']//h2")
	WebElement facebookHeader;
	
	@FindBy(xpath="//form[@id='login_form']//a[@aria-label='Log in']")
	WebElement facebookLoginButton;
	
	@FindBy(xpath="//div[@id='email_container']")
	WebElement facebookUserNameInput;	
	
	@FindBy(xpath="//div[contains(@class,'competitionTable')]")
	WebElement premierLeagueTable;
	
	
	public WebElement getFacebookUserNameInput() {
		return facebookUserNameInput;
	}
	//dynamic xpath to get the team's position from the premier league table
	public WebElement getTeamPosition(String teamName)
	{		
		return driver.findElement(By.xpath("//div[contains(@class,'competitionTable')]//tbody/tr[td[contains(@class,'team-short') and text()='" + teamName + "']]/td[contains(@class,'pos')]"));
	}
	//dynamic xpath to get the team's position from the premier league table
	public WebElement getTeamPoints(String teamName)
	{
		return driver.findElement(By.xpath("//div[contains(@class,'competitionTable')]//tbody/tr[td[contains(@class,'team-short') and text()='" + teamName + "']]/td[contains(@class,'score-pts')]"));
	}
	//dynamic xpath
	public WebElement getSocialMediaLink(String handleName) {
		return driver.findElement(By.xpath("(//ul[contains(@class,'linksHolder')])[1]/li[@data-social-scope='" + handleName + "']"));
	}
	

	
	public WebElement getGalleryPrevButton() {
		return galleryPrevButton;
	}
	
	public WebElement getGalleryNextButton() {
		return galleryNextButton;
	}

	public SportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openFirstSportsArticle() {
		sportsCategoryFirstArticleLink.click();
	}

	public void openImageGallery() {
		Action.scrollInToView(driver, mediaLinksHolder);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		new Actions(driver)
				.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(FirstGalleryButton)))
				.click()
				.build()
				.perform();
	}
	
	public int getImageNumber()
	{	
		int imageNumber = Integer.parseInt(counterLabel.getText().split(" ")[0]);
		return imageNumber;
	}
	
	public void openSocialMedia()
	{
		Action.scrollInToView(driver, mediaLinksHolder);		
		new Actions(driver)
		.moveToElement(FirstGalleryButton)
		.build()
		.perform();		
		
		
	}	
	
	public String verifyFacebookDialog(String handleName)
	{		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));		
		String mainWindow = driver.getWindowHandle();				
		getSocialMediaLink(handleName).click();		
		Action.waitForNewWindow(driver,10);
		Set<String> windows = driver.getWindowHandles();
	    Iterator<String> iterator = windows.iterator();	
	    String windowTitle=null;
	    
	    while (iterator.hasNext()) {	    	
	          String childWindow = iterator.next();	          
	          if (!mainWindow.equalsIgnoreCase(childWindow)) {
	              driver.switchTo().window(childWindow);   
	              wait.until(ExpectedConditions.titleContains("Facebook"));
	              windowTitle = driver.getTitle();
	              System.out.println(windowTitle);
	           }
	       }
	    return windowTitle;
	}
	
	public void displayPremierLeagueDetails(String teamName)
	{
		Action.scrollInToView(driver, getTeamPosition(teamName));	
	}
	
}
