package com.tutorialsninja.qa.Applicationpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
WebDriver driver;
	public RegisterPage(WebDriver d)
	{
		driver=d;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	WebElement firstName;
	
	@FindBy (id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement eMail;
	
	@FindBy(id = "input-telephone")
	WebElement Telephoneno;
	
	@FindBy(id = "input-password")
	WebElement PassWord;
	
	@FindBy(id ="input-confirm")
	WebElement confirmbutton;
	
	
	@FindBy(xpath="//input[@type=\"checkbox\"]")
	WebElement checkboxtick;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement submitbuttoncheck;
	

	
	
	
	
	
	public void firstnametextbox()
	{
		firstName.sendKeys("sharath");
	}
	
	public void lastnametextbox()
	{
		lastName.sendKeys("devadiaga");
	}
	
	public void emailtextbox(String eMAiltext)
	{
		eMail.sendKeys(eMAiltext);
	}
	public void telephonotextfield()
	
	{
		Telephoneno.sendKeys("122345454545");
	}
	
	public void Passwordtextfield()
	{
		PassWord.sendKeys("1345545");
	}
	
	
	public void confirmpassword()
	{
		confirmbutton.sendKeys("1345545");
	}
	
	public void checkboxtickbutton()
	{
		checkboxtick.click();
	}
	public void submitbuttonbutton()
	{
		submitbuttoncheck.click();
	}

	
	
}
