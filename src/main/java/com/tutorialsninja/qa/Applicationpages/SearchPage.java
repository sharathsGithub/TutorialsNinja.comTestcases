package com.tutorialsninja.qa.Applicationpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver d) {

		driver = d;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//input[@type=\"text\"]")
	WebElement Searchtextfield;
	
	@FindBy(xpath="//span[@class=\"input-group-btn\"]//button[@type=\"button\"]")
	WebElement searchbutton;
	
	
	public void searchTextfields()
	{
		Searchtextfield.sendKeys("hp");
	}
	
	public void searchBUTTONs()
	{
		searchbutton.click();
	}
	
}
