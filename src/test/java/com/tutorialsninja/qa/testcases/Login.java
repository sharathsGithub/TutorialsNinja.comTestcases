package com.tutorialsninja.qa.testcases;


  
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Applicationpages.EditurAccountPage;
import com.tutorialsninja.qa.Applicationpages.Homepage;
import com.tutorialsninja.qa.Applicationpages.LoginPage;
import com.tutorialsninja.qa.base.Basess;
import com.tutuorialsninja.qa.utils.Utilities;

public class Login extends Basess {
Login()
{
super();	
}
	
	
	public WebDriver driver;
	@BeforeMethod()
	public void mainmetod()
	 {
		driver=intializeBrowserandopentheApplicationURL(prop.getProperty("browser"));      
		Homepage MyAccount=new Homepage(driver);
		MyAccount.clickonthemyaccount();
        MyAccount.clickonlogindropdownbutton();
	 }
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test(priority=1,dataProvider = "suplytestdata")
	public void loginwithvaildcredentials(String email,String password) throws IOException
	{
	
	    
	   //i have moved the chrome driver to the before method annotation
		
		//i have also moved all the waits and  clicked on the method 
	     LoginPage Loginn=new LoginPage(driver);
	     Loginn.Emailtextfield(email);
		Loginn.PasswordTextfield(password);
		Loginn.clickonloginbuttonn();
		EditurAccountPage accntPage=new EditurAccountPage(driver);
	String USerName=accntPage.Getdisplaystatusofaccountinformationaction();
	//Assert.assertEquals("wrong one", USerName);
		if(USerName.equals("My account is not diaplayed"))
		{
			Assert.assertTrue(true);
		}else
		{
			Capturescreenshot(driver, USerName);
			System.out.println("failed");
			Assert.assertTrue(false);
		}
			//Assert.assertTrue(accntPage.Getdisplaystatusofaccountinformationaction(),"edit your message");	
		
			
		//i have moved the quit method to tear down method
	      
	}
	
	@DataProvider
	public Object[][] suplytestdata()
	{
		Object[][] data = Utilities.getTestDataFromExcel("Sheet1");
				return data;
	}
	
	
	
	
	
	
	
	
	@Test(priority=2)
	public void Loginwithinvalidcredentials()
	{
		
		LoginPage Loginn=new LoginPage(driver);
		Loginn.Emailtextfield(Utilities.generateEmailTimestamp());
		Loginn.PasswordTextfield("123456");
	    Loginn.clickonloginbuttonn();
		 

	   String actualwarning= Loginn.validatingthewarningmessage();
	   String  expectedwarningmessage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualwarning.contains(expectedwarningmessage),"expectedwarning mewssage is displayed");
		
	
		
	}
	

	
	
	
}
