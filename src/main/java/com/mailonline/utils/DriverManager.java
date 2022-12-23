package com.mailonline.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	public WebDriver driver;
	
	public WebDriver getDriver()
	{
		try
		{			
	    driver = new ChromeDriver();		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;		
	}
	
	public void closeDriver(WebDriver driver)
	{
		driver.quit();
	}
	
}