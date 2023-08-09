package com.tutorialsninja.qa.Applicationpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class confirmationpage {

	WebDriver driver;
	public confirmationpage(WebDriver d)
{
	driver=d;
PageFactory.initElements(driver, this);
}
	
	@FindBy (xpath="//div[@id=\"content\"]//h1")
	WebElement coonenttext;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement continuebutton;
	
	public String CooneenttextSS()
	{
		
		String ccnt=coonenttext.getText();
	    return ccnt;
	}
	
	public void contiNue()
	{
		continuebutton.click();
	}
	
	
	
}
