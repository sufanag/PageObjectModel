package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
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
				
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				
				 log=Logger.getLogger(TestBase.class);
			
			}
			eventListener = new WebEventListener();
			
			e_driver = new EventFiringWebDriver(driver);
			e_driver.register(eventListener);
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Util.IMPLICITWAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Util.IMPLICITWAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			log.info("launching url");
			
		}
		
}
