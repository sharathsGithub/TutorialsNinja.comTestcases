package com.tutorialsninja.qa.Applicationpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SEARCHvalidattion {
	WebDriver driver;

	public SEARCHvalidattion(WebDriver d) {

		driver = d;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy (linkText ="HP LP3065")
	WebElement validationofhptext;
	
	
	public boolean VALIDATIONOFHptext()
	{
		boolean ltxt=validationofhptext.isDisplayed();
         	return ltxt;
	}
	
	
}
