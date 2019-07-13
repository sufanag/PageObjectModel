package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
  @Test(priority=1)
  public void verifyHomeLink() {
	  
	  
	  Assert.assertEquals("CRM", homePage.verifyHomeTitle(),"Title of page is as expected");
  }
  
  /*@Test(priority=2)
  public void verifyName() {
	  Assert.assertEquals("Sufana Gulshan", homePage.verifyName());
  }*/
  
  @Test(priority=3)
  public void clickTasksLink() {
	  homePage.goToTasks();
  }
  
  
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
}
