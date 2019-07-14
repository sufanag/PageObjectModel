package com.crm.qa.base;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadlessChrome
{
  @Test
  public void createChromeDriverHeadless() throws IOException
  {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\Driver\\chromedriver.exe");
		
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setBinary("C:\\Users\\sufsa\\AppData\\Local\\Google\\Chrome SxS\\Application\\chrome.exe");
      chromeOptions.addArguments("--headless");

      WebDriver Driver = new ChromeDriver(chromeOptions);
      Driver.navigate().to("https://ui.freecrm.com/");

      WebDriverWait waitForUsername = new WebDriverWait(Driver, 5000);
      System.out.println(Driver.getTitle());

     
  }
}