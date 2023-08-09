package com.tutorialsninja.qa.Applicationpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "input-email") WebElement emailTextfield;
	
	@FindBy (id="input-password") WebElement passwordTextfield;
	
	@FindBy(xpath="//input[@type=\"submit\"]") WebElement loginbuttonnn;

	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") WebElement validation;
	
    public void Emailtextfield(String Emailtext)
    {
    	emailTextfield.sendKeys(Emailtext);
    }

    public void PasswordTextfield(String passwordText)
    {
    passwordTextfield.sendKeys(passwordText);
    }
     public void clickonloginbuttonn()
     {
    	 loginbuttonnn.click();
     }

     public String validatingthewarningmessage()
     {
    	 String displayedmesage=validation.getText();
    	 return displayedmesage;
     }
     
     
}
