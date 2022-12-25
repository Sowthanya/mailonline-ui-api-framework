package com.mailonline.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

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

	@After
	public void closeDriver() {
		driver.quit();
	}

}