package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath="//a[@href='/contacts']")
	WebElement contactslink;
	
	@FindBy(xpath="//button[text()='New']")
	WebElement btnNew;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="company")
	WebElement company;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement btnSave;
	
	@FindBy(name="address")
	WebElement address;
	
	//constructor
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	
	
	public void clickNewContact() {
		btnNew.click();
	}
	
	public void enterContactDetails(String tit,String FN,String LN,String addr) {
		firstName.sendKeys(FN);
		lastName.sendKeys(LN);
		address.sendKeys(addr);
		//company.sendKeys("Company");
		
		btnSave.click();
	}
	

}
