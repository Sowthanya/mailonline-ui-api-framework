package com.mailonline.ui.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mailonline.pages.HomePage;
import com.mailonline.pages.SportPage;
import com.mailonline.utils.DriverManager;

import io.cucumber.java.en.When;

public class SportPageStepDef {
	WebDriver driver;
	SportPage sportPage;
	
	public SportPageStepDef(DriverManager driverManager)
	{
		this.driver = driverManager.getDriver();
		sportPage = new SportPage(driver);		
	}
	
	@When("I open the first article")
	public void openArticle()
	{
		driver.findElement(By.xpath("//div[@data-track-module='football-desktop-ap-triple_article_headline']/h2/a")).click();
	}
}