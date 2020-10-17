package Jenkins.Automation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LayoutOCR extends Commonfiles{
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static Date date = new Date();

	public static ExtentHtmlReporter htmlReport=new ExtentHtmlReporter("ExtentReport/output.html");
	public static ExtentReports extent=new ExtentReports();
	
	@BeforeClass
	public void launchURl() {
		System.setProperty("webdriver.chrome.driver","Webdriver//chromedriver.exe");
		String userProfile= "C:\\Users\\s.d.saravanan\\Documents\\Selenium\\ChromeProfile";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir="+userProfile);
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
	    driver.get("https://image2excel-test.accenture.com");
	}
	
	@Test(priority=1)
	public void Login() throws Exception {
		extent.attachReporter(htmlReport);
		ExtentTest test=extent.createTest("Login");
		driver.findElement(By.xpath("//*[@id='userNameInput']")).sendKeys("s.d.saravanan");
		driver.findElement(By.xpath("//*[@id='passwordInput']")).sendKeys("Lordsurya@1996");
		driver.findElement(By.xpath("//*[@id='submitButton']")).click();
		Thread.sleep(100000);
		Take_Screenshot(driver);
		test.info("Screenshot Taken");
	    extent.flush();
	}
	
	
}
