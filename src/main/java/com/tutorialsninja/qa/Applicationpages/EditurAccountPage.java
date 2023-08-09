package com.tutorialsninja.qa.Applicationpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditurAccountPage {
WebDriver driver;
	public EditurAccountPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//a[text()='Edit your account information']") 
	private WebElement EditAcntpg;
	
	public String Getdisplaystatusofaccountinformationaction ()
	{
        String displaystatus=EditAcntpg.getText();
        return displaystatus;
	}
	
	
}
