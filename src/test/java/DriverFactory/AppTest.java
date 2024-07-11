package DriverFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pageclasses.Customer_module;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import config.AppUtil;
import utilities.ExcelFileUtil;


public class AppTest  extends AppUtil				

{
	String  inputpath="./Input/customerdata.xlsx ";
	String outputpath="./output.dresults.xlsx";
	String Tcsheet="customer";
	ExtentReports reports;
	ExtentTest logger;
    @Test
	public void starttest() throws Throwable 
    {
		reports=new ExtentReports("./target/extentreports/customer.html");
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc=xl.rowCount(Tcsheet);
		Reporter.log("no.of rows"+rc,true);
		for(int i=1;i<=rc;i++) {
			
			logger=reports.startTest("customer");
			logger.assignAuthor("Phani");	
			String cname=xl.getCellData(Tcsheet, i, 0);
			String address=xl.getCellData(Tcsheet, i, 1);
			String city=xl.getCellData(Tcsheet, i, 2);
			String country=xl.getCellData(Tcsheet, i, 3);
			String cperson=xl.getCellData(Tcsheet, i, 4);
			String pnumber=xl.getCellData(Tcsheet, i, 5);
			String email=xl.getCellData(Tcsheet, i, 6);
			String mnumber=xl.getCellData(Tcsheet, i, 7); 
			String notes=xl.getCellData(Tcsheet, i, 8);
			
			Customer_module cus=PageFactory.initElements(driver,Customer_module.class);
			boolean res=cus.add_customer(cname, address, city, country, cperson, pnumber, email, mnumber, notes);
			logger.log(LogStatus.INFO, cname+"----"+address+" ------"+city+"   " +" ---"+ country+" ---" +cperson+"  " +pnumber+"----"+ email+"---" +mnumber+"---" +notes);
			if(res) {
				xl.setCellData(Tcsheet, i, 9,"Pass",outputpath);
				logger.log(LogStatus.PASS,"Customer added success");
				
			}
			else
			{
				xl.setCellData(Tcsheet, i, 9,"Fail",outputpath);
				logger.log(LogStatus.FAIL,"Customer not added success");
				
			}
			reports.endTest(logger);
			reports.flush();
		}
	}
	  
	

}
