package com.mailonline.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class HomePage 
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}	

	public boolean launchAppURL(String url)
	{
		try
		{
		driver.get(url);
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	
}