package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.crm.qa.util.Util;
import com.crm.qa.util.WebEventListener;

public class TestBase {

		public static WebDriver driver;
		public static Properties prop;
		public static EventFiringWebDriver e_driver;
		 public static WebEventListener eventListener;
		 public static Logger log;
		
		public TestBase() {
			try {
				
				 prop = new Properties();
				FileInputStream fin = new FileInputStream("C:\\Users\\sufsa\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			
				prop.load(fin);
			
		}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		public static void initialization() {
			
			
			String browsername = prop.getProperty("browser");
			if(browsername.equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\Driver\\chromedriver.exe");
				
				ChromeOptions chromeOptions = new ChromeOptions();
			      chromeOptions.setBinary("C:\\Users\\sufsa\\AppData\\Local\\Google\\Chrome SxS\\Application\\chrome.exe");
			      chromeOptions.addArguments("--headless");

			       driver = new ChromeDriver(chromeOptions);
			      //Driver.navigate().to("https://ui.freecrm.com/");

			     // WebDriverWait waitForUsername = new WebDriverWait(Driver, 5000);
				
				 log=Logger.getLogger(TestBase.class);
			
			}
			eventListener = new WebEventListener();
			
			e_driver = new EventFiringWebDriver(driver);
			e_driver.register(eventListener);
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Util.IMPLICITWAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Util.IMPLICITWAIT, TimeUnit.SECONDS);
			driver.navigate().to(prop.getProperty("url"));
			System.out.println(driver.getTitle());
			log.info("launching url");
			
		}
		
}
