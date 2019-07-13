package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Util;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	ContactsPage contactsPage;
	HomePage homePage;
	
	
	public ContactsPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.goToContacts();
	}
	
 /*@Test(priority=1)
 public void verifyNewContact() {
	 contactsPage.clickNewContact();
 }*/
  
 
 @DataProvider
 public Object[][] getCrmData() {
	  Object data[][] = Util.getTestData("contacts");
	  return data;
 }
 
  @Test(priority=1,dataProvider="getCrmData")
  public void enterDetails(String title,String fn,String ln,String company) {
	  System.out.println(title);
	  contactsPage.clickNewContact();
	  contactsPage.enterContactDetails(title,fn, ln,company);
  }
  
 
  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }
}
