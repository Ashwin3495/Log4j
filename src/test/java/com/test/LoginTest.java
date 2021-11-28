package com.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.v96.log.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
	
	WebDriver driver;
	Logger log=Logger.getLogger(LoginTest.class);

	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("-----------Launched------------");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://classic.freecrm.com/index.html");
		log.info("-------Application URL------------");
		log.warn("-------Warning-------");
		log.fatal("-------Fatal-------");
		log.debug("-------Debug-------");
	}
	
	@Test(priority=1)
	public void freeCrmTitlesTest()
	{
		log.info("-------Titel Test-------");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Free CRM  - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void freeCRMLogoTest()
	{
		log.info("-------Logo Test-------");
		boolean b=driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		log.info("-------Closed-------");
	}
}
