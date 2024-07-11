package config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.pageclasses.AdminLogin;
import com.pageclasses.logout;

public class AppUtil {
public static WebDriver driver;
@BeforeTest
public static void setUp() 
{
	driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("http://webapp.qedgetech.com/");
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
     AdminLogin login=PageFactory.initElements(driver, AdminLogin.class);
     login.verify_login("admin", "master");	
}
@AfterTest
public static void teardown() {
	logout logout= PageFactory.initElements(driver, logout.class);
	logout.adminlogout();
	driver.quit();
	
}
}
