package com.mailonline.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage 
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}	

	public void launchAppURL(String url)
	{
		try
		{
		driver.get(url);
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}catch(Exception e)
		{
			e.printStackTrace();			
		}
	}
	
	public String getDateFromHomePage()
	{
	   String dateToday = driver.findElement(By.xpath("//div[@class='weather']/strong")).getText();	 
	   return dateToday;
	}
	
	public String getHomePageName()
	{
		String pageName = driver.findElement(By.xpath("//div[@class='h1-page-last-updated']/h1")).getText();
	    return pageName;
	}
	
}