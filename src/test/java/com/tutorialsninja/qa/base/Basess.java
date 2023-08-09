package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutuorialsninja.qa.utils.Utilities;

public class Basess {
	WebDriver driver;
	public Properties prop ;
	
	
	
	public  Basess() 
	{
		prop = new Properties();
File propfile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(propfile);
			prop.load(fis);
		    } 
		catch (Throwable e)
		{
			e.printStackTrace();
		}

	}

	public WebDriver intializeBrowserandopentheApplicationURL(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} 
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) 
		{
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.ImpLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	
	public void Capturescreenshot(WebDriver driver,String testName) throws IOException
	{
		TakesScreenshot scrnsht=(TakesScreenshot)driver;
		File src=scrnsht.getScreenshotAs(OutputType.FILE);
		
		File dsc=new File(System.getProperty("user.dir")+"//ScreenShott//"+testName+".png");
		FileUtils.copyFile(src, dsc);
	}

}
