package com.tutorialsninja.qa.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Applicationpages.Homepage;
import com.tutorialsninja.qa.Applicationpages.RegisterPage;
import com.tutorialsninja.qa.Applicationpages.confirmationpage;
import com.tutorialsninja.qa.base.Basess;
import com.tutuorialsninja.qa.utils.Utilities;

import junit.framework.Assert;

public class register extends Basess {
	
	 public WebDriver driver;
	
	register()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driver=intializeBrowserandopentheApplicationURL(prop.getProperty("browser"));
		Homepage resgispg=new Homepage(driver);
		resgispg.clickonthemyaccount();
	    resgispg.clickonregisterButton();
	}
	
	@AfterMethod
	public void teardown()
	{
		
	driver.quit();
	}

@Test
public void registerwithvalidcredentials()
{
	   RegisterPage restpgg=new RegisterPage(driver);
	    restpgg.firstnametextbox();
	    restpgg.lastnametextbox();
	    restpgg.emailtextbox(Utilities.generateEmailTimestamp());
	    restpgg.telephonotextfield();
	    restpgg.Passwordtextfield();
	    restpgg.confirmpassword();
	    restpgg.checkboxtickbutton();
	    restpgg.submitbuttonbutton();
	    
    confirmationpage cdf=new confirmationpage(driver);
  String Actualmesage=cdf.CooneenttextSS(); 
   Assert.assertEquals(Actualmesage,"Your Account Has Been Created!");
   cdf.contiNue();
}


}
