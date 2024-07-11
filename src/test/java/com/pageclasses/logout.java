package com.pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class logout {
	@FindBy(xpath="(//a[.=' Logout'])[2]")
	WebElement Objlogout;

	public void adminlogout() {
		Objlogout.click();
	}
}
