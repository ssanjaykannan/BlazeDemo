package Jenkins.Automation;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

public class SampleScript extends Commonfiles{
	
	public static DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	public static Date date = new Date();
    public String ReportExtent="Report"+dateFormat.format(date);
	public static ExtentHtmlReporter htmlReport=new ExtentHtmlReporter("Extent Report/output.html");
	public static ExtentReports extent=new ExtentReports();
	
	@BeforeClass
	public void launchURl() {
		System.setProperty("webdriver.chrome.driver","Webdriver//chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void FindFlight() throws Exception {
		extent.attachReporter(htmlReport);
		ExtentTest test=extent.createTest("FindFlight");
		
		Access_Dropdown("DepartureCity","Paris");
		Access_Dropdown("DestinationCity","London");
		Click("FindFlight");
		
		test.pass("Find Flight is Successful");
		
	}
	
	@Test(priority=2)
	public void ChooseFlight() throws Exception {
		extent.attachReporter(htmlReport);
		ExtentTest test=extent.createTest("FindFlight");
		
		Click("ChooseFlight");
		test.pass("Choose Flight is Successful");
		
		extent.flush();
	}
	
	@AfterClass
	public void Teardown() throws Exception {
		 File file1=new File("Reference Report//"+ReportExtent+".html");
			
		 File file2 = new File("Extent Report//output.html");
		 Files.copy(file2,file1);
	}
	
	
}
