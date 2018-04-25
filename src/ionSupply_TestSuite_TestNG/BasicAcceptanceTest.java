package ionSupply_TestSuite_TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BasicAcceptanceTest { 
	
	public WebDriver driver;
	
	 @BeforeSuite
	  public void beforeSuite() {
		 driver = new FirefoxDriver();
		  driver.get("http://localhost/TestApp/");
		  
			//Provide Login Data Here

               //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		        //driver.findElement(By.xpath(".//*[@id='account']/a")).click();

           // Argument passed will be used here as String Variable

		        //driver.findElement(By.id("log")).sendKeys(sUsername);

		        //driver.findElement(By.id("pwd")).sendKeys(sPassword);
	
              //driver.findElement(By.id("login")).click();

              //driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
			  
			  
	  }

	 @AfterSuite
	 
	 public void afterSuite() {
	 
		 driver.quit();
	 }
	  
	  @Test	
		public void launchHomePage() {
		  
		    
			driver.get("http://localhost/TestApp/Pages/Home");
			driver.findElement(By.id("FeaturedContent_ChartTopLeft1"));
			
            
		}
	}


