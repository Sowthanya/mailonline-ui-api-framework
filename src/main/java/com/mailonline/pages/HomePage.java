package com.mailonline.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mailonline.utils.GenericUtils;

public class HomePage 
{
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='weather']/strong")
	WebElement 	dateTodayLabel;
	
	@FindBy(xpath="//div[@class='weather']/a/span[1]")
	WebElement currentTimeLabel;
	
	@FindBy(xpath="//div[@class='h1-page-last-updated']/h1")
	WebElement pageNameHeader;
	
	@FindBy(xpath="//div[@class='sport nav-secondary-container']/div[contains(@data-track-module,'nav-secondary')]")
	WebElement secondaryNavMenuContainer;
	
	//dynamic xpath- can be reused for other primary navigations
	public WebElement getPrimaryNavMenuItem(String menuItemName)
	{
		WebElement menuPrimary = driver.findElement(By.xpath("//div[contains(@class,'page-header')]//li[@class='" + menuItemName + "']//a"));
		return menuPrimary;
	}
	
	//dynamic xpath- can be reused for other secondary navigations
	public WebElement getSecondaryNavMenuItem(String menuItemName)
	{
		WebElement menuSecondary =driver.findElement(By.xpath("//div[@class='sport nav-secondary-container']//li/a[text()='" + menuItemName + "']"));
		return menuSecondary;
	}
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}	

	public void launchAppURL(String url)
	{
		try
		{
		driver.get("https://www.hidemyass-freeproxy.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("form_url_fake")).sendKeys(url);
		driver.findElement(By.xpath("//*[@class='button primary']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}catch(Exception e)
		{
			e.printStackTrace();			
		}
	}
	
	public String getDateTimeFromHomePage()
	{
	   String dateToday = dateTodayLabel.getText();
	   String timeNow = currentTimeLabel.getText();
	   return dateToday + " " + timeNow;
	}
	
	public String getHomePageName()
	{
		String pageName = pageNameHeader.getText();
	    return pageName;
	}
	
	public String getPrimaryNavBackgroundColour()
	{
		String bckgclr = GenericUtils.getBackgroundColor(getPrimaryNavMenuItem("sport"));
		return bckgclr;
	}
	
	public String getSecondaryNavBackgroundColour()
	{
		String bckgclr = GenericUtils.getBackgroundColor(secondaryNavMenuContainer);				
		return bckgclr;
	}
	
		
}