package com.tutorialsninja.qa.Applicationpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage{

	WebDriver driver;
	
	public Homepage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//span[text()='My Account']") 
	WebElement TutorialsninjaHomePage;
	
	@FindBy(xpath ="//a[text()='Login']")
	WebElement Logindropdownbutton;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")
	WebElement registerbutton;
	
	public void clickonthemyaccount()
	{
		TutorialsninjaHomePage.click();
	}
	
	public void clickonlogindropdownbutton()
	{
		Logindropdownbutton.click();
	}
	
	
	public void clickonregisterButton()
	{
		registerbutton.click();
	}
}
