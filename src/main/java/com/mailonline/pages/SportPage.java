package com.mailonline.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mailonline.utils.Action;

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

}
