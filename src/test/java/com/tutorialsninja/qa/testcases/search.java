package com.tutorialsninja.qa.testcases;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Applicationpages.SEARCHvalidattion;
import com.tutorialsninja.qa.Applicationpages.SearchPage;
import com.tutorialsninja.qa.base.Basess;

public class search extends Basess {
	
public	WebDriver driver;
	@BeforeMethod
	public void setup2()
	{
		driver=intializeBrowserandopentheApplicationURL(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test
public void searchcontext()
{
SearchPage sspg=new SearchPage(driver);
sspg.searchTextfields();
sspg.searchBUTTONs();
SEARCHvalidattion Sgh=new SEARCHvalidattion(driver);
Assert.assertTrue(Sgh.VALIDATIONOFHptext());

}
}
