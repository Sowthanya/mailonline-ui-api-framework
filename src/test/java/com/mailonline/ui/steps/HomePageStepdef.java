package com.mailonline.ui.steps;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;

public class HomePageStepdef{
	
	@Given("I launch the application")
	public void launchApplication()
	{
		WebDriver driver =  new ChromeDriver();
		try
		{
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		}catch(Exception e)
		{
			e.printStackTrace();		
		}		
	}
	
}