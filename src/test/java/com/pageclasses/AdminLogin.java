package com.pageclasses;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {
	@FindBy(id="btnreset")
	WebElement Objreset;
	@FindBy(xpath="//input[@id='username']")
	WebElement Objuname;
	@FindBy(xpath="//input[@id='password']")
	WebElement Objpass;
	@FindBy(id="btnsubmit")
	WebElement Objlogin;
	
	public void verify_login(String user,String pass) {
		Objreset.click();
		Objuname.sendKeys(user);
		Objpass.sendKeys(pass);
		Objlogin.click();
		
	}
	

}
