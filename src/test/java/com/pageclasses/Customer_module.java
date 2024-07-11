package com.pageclasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Customer_module {
	WebDriver driver;
	public Customer_module(WebDriver driver) {
		this.driver=driver;
		
	}
	@FindBy(xpath="(//a[contains(.,'Customers')])[2]")
			WebElement Objcustomerslink;
	
	@FindBy(xpath="(//span[contains(@data-caption,'Add')])[1]")
	WebElement ObjClickaddIcon;
	
	@FindBy(name="x_Customer_Number")
	WebElement Objcustomernumber;
	
	@FindBy(name="x_Customer_Name")
	WebElement Objcname;
	
	@FindBy(name="x_Address")
	WebElement Objaddress;
	
	@FindBy(name="x_City")
	WebElement Objcity;
	
	@FindBy(name="x_Country")
	WebElement Objcountry;
	
	@FindBy(name="x_Contact_Person")
	WebElement Objcperson;
	
	@FindBy(name="x_Phone_Number")
	WebElement Objpnumber;
	
	@FindBy(name="x__Email")
	WebElement Objemail;
	
	@FindBy(name="x_Mobile_Number")
	WebElement Objmnumber;
	
	@FindBy(name="x_Notes")
	WebElement Objnotes;
	
	@FindBy(id="btnAction")//btnAction
	WebElement Objaddbtn;
	
	@FindBy(xpath="//button[normalize-space()='OK!']")//button[normalize-space()='OK!']
	WebElement Objconfirm;
	
	@FindBy(xpath="//button[@class='ajs-button btn btn-primary']")//button[@class='ajs-button btn btn-primary']
	WebElement Objalertok;
	
	@FindBy(xpath="//span[@data-caption='Search']")
	WebElement Objsearchpannel;
	
	@FindBy(xpath="//input[@id='psearch']")
	WebElement Objsearchbox;
	
	
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement Objsearchbutton;
	
	@FindBy(xpath="//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement webtable;
	
	public boolean add_customer(String cname,String address,String city,String country,String cperson,String pnumber,String email,String mnumber,String notes) throws Throwable
	
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(this.Objcustomerslink).click().perform();
		Thread.sleep(2000);
		ac.moveToElement(this.ObjClickaddIcon).click().perform();
		Thread.sleep(2000);
		String exp_data=this.Objcustomernumber.getAttribute("value");
		this.Objcname.sendKeys(cname);
		this.Objaddress.sendKeys(address);
		this.Objcity.sendKeys(city);
		this.Objcountry.sendKeys(country);
		this.Objcperson.sendKeys(cperson);
		this.Objpnumber.sendKeys(pnumber);
		this.Objemail.sendKeys(email);
		this.Objmnumber.sendKeys(mnumber);
		this.Objnotes.sendKeys(notes);
		ac.moveToElement(this.Objaddbtn).click().perform();		
		Thread.sleep(3000);
		 ac.moveToElement(this.Objconfirm).click().build().perform();
		 ac.pause(4000);
		 ac.moveToElement(this.Objalertok).click().build().perform();
		 Thread.sleep(3000);
		 if(!this.Objsearchbox.isDisplayed())
			 this.Objsearchpannel.click();
		 this.Objsearchbox.clear();
		 this.Objsearchbox.sendKeys(exp_data);
		 this.Objsearchbutton.click();
		 Thread.sleep(4000);
		 String act_data=this.webtable.getText();
		 	if(act_data.equals(exp_data)) {
		 		Reporter.log(act_data+" "+exp_data,true);
		 		return true;
		 	}
		 	else {
		 		Reporter.log(act_data+" "+exp_data,true);
		 		return false;
		 	}
		 		

	}
}
