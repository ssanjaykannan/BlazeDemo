package Jenkins.Automation;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commonfiles {
	 public static WebDriver driver;
	   public static Commonfiles wc=new Commonfiles();
	   public static Properties p=new Properties();
	   
	      public void Access_Dropdown(String xpath,String Value) throws Exception {
	       FileInputStream fis=new FileInputStream("Input_Property/Input.properties");
		   p.load(fis);
	       System.out.println("Accessing Dropdown "+p.getProperty(xpath));
			WebElement dropdown=driver.findElement(By.xpath(p.getProperty(xpath)));
			Select select=new Select(dropdown);
			select.selectByVisibleText(Value);
		}
		
	    public void Type(String xpath,String value) throws Exception {
	    	FileInputStream fis=new FileInputStream("Input_Property/Input.properties");
			p.load(fis);
	         System.out.println("Type "+p.getProperty(value)+" in xpath "+p.getProperty(xpath));
	         driver.findElement(By.xpath(p.getProperty(xpath))).sendKeys(p.getProperty(value));
	    }
	    
	    public void Type_Content(String xpath,String value) throws Exception {
	    	FileInputStream fis=new FileInputStream("Input_Property/Input.properties");
			p.load(fis);
	         System.out.println("Type "+value+" in xpath "+p.getProperty(xpath));
	         driver.findElement(By.xpath(p.getProperty(xpath))).sendKeys(value);
	    }
		
	    public void Click(String xpath) throws Exception {
	    	FileInputStream fis=new FileInputStream("Input_Property/Input.properties");
			p.load(fis);
	    	 System.out.println("Click on the Element "+p.getProperty(xpath));
	    	 driver.findElement(By.xpath(p.getProperty(xpath))).click();
	    	Thread.sleep(2000);
	    }
	    
	    public String GetText(String xpath) throws Exception {
	    	FileInputStream fis=new FileInputStream("Input_Property/Input.properties");
			p.load(fis);
			System.out.println("Getting Text from the Element "+p.getProperty(xpath));
	    	String Content=driver.findElement(By.xpath(p.getProperty(xpath))).getText();
	    	return Content;
	    }
	    
	    public void ExplicitWait(String xpath) throws Exception {
	    	FileInputStream fis=new FileInputStream("Input_Property/Input.properties");
			p.load(fis);
	    	System.out.println("Explicit Wait for the Element  "+p.getProperty(xpath));
	    	WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty(xpath))));
	    }
	    
	    
	    public void Delete_File(String FileName) {
	    	File dir = new File("C:\\Users\\s.d.saravanan\\Downloads");
	    	  File[] dirContents = dir.listFiles();
	        
	    	  for (int i = 0; i < dirContents.length; i++) {
	    	      if (dirContents[i].getName().startsWith(FileName)) {
	    	          dirContents[i].delete();
	    	          System.out.println("Delete Successful");
	    	      }
	    	     
	    	    }   
	    }
	    
	    public  Boolean Verify_existFile(String fileName) throws Exception {
	     File dir = new File("C:\\Users\\s.d.saravanan\\Downloads");
	   	 File[] dirContents = dir.listFiles();
       int Count=0;
	   	  for (int i = 0; i < dirContents.length; i++) {
	   	      if (dirContents[i].getName().startsWith(fileName)) {
	   	       System.out.println("File Exist");
	   	       Count=Count+1;
	   	      }
	   	  }
	   	  
	   	  System.out.println("Export Count"+Count);
	   	  if(Count==1) {
	   		  return true;
	   	  }
	   	  else {
	   		  return false;
	   	  }
	    }	
	    
	    
	    public void autoIT_UploadFile() throws Exception {
	    	Runtime.getRuntime().exec("AutoIT\\FileUploadSupport.exe");
	    }
	    
	    public void Take_Screenshot(WebDriver driver) throws Exception {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
		    String destination = System.getProperty("user.dir") + "\\TestScreenshots\\"+"Proof"+dateName+".png";
		    File finalDestination = new File(destination);
		    FileUtils.copyFile(source, finalDestination);
     }

}
