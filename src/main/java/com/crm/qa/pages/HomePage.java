package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Util;



public class HomePage extends TestBase{

	
	@FindBy(xpath="//a[@href='/home']")
	WebElement homelink;
	
	
	@FindBy(xpath="//div[contains(text(),'Sufana Gulshan']")
	WebElement displayname;
	
	
	@FindBy(xpath="//a[@href='/tasks']")
	WebElement tasklink;
	
	@FindBy(xpath="//a[@href='/contacts']")
	WebElement contactslink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomeTitle() {
		return driver.getTitle();
	}
	
	public WebElement verifyName() {
		
		return displayname;
		
	}
	
	
	public TasksPage goToTasks() {
		tasklink.click();
		
		return new TasksPage();
	}
	
	public ContactsPage goToContacts() {
		 contactslink.click();
		 driver.manage().timeouts().implicitlyWait(Util.IMPLICITWAIT, TimeUnit.SECONDS);
		 return new ContactsPage();
	}
	
	
}