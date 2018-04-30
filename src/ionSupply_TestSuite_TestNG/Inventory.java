package ionSupply_TestSuite_TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import ionSupply_TestSuite_TestNG.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class Inventory {
	
	public WebDriver driver;
	 public Actions builder;
	 
	 @BeforeSuite    
	  public void beforeSuite() {
		 
		  driver = new FirefoxDriver();
		  driver.get("http://localhost/TestApp/");
		  driver.manage().window().maximize();
		  
		  }
	 

	 @AfterSuite
	 
	 public void afterSuite() {
	 
		 driver.quit();
	 }
	 	 
	  @Test (dataProvider = "excelData")	  
	  public void addInventoryBasicFlow(String sUpdateAmt) throws Exception {
		  
		  driver.findElement(By.id("FeaturedContent_AddBatchLnkBtn")).click();
		  
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		  driver.findElement(By.id("MainContent_ItemGv_SelectBtn_14")).click();
		  
          String ItemIdLbl = driver.findElement(By.id("MainContent_ItemIdLbl")).getText();
		  
		  String QtyAmtLbl = driver.findElement(By.id("MainContent_QtyRemLbl")).getText();
		   
		  ExcelUtils.setCellData(ItemIdLbl, 1, 2);
		  ExcelUtils.setCellData(QtyAmtLbl, 1, 3);
		    	
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      
	      driver.findElement(By.id("MainContent_AmountTxt")).sendKeys(sUpdateAmt);
	 
	  }
	  
	  @Test 
	  public void sideNav() {
//	     driver.findElement(By.id("mySidenav")).click();
//	  
//	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//	  
//	  driver.findElement(By.id("mySidenav > a:nth-child(3)")).click();
//	  
//	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//	  
//	  driver.findElement(By.id("MainContent_ChooseCategoryDdl")).click();
//	  
//	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//	  driver.findElement(By.linkText("Ingredient")).click();
//	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//	  driver.findElement(By.id("MainContent_SearchBtn")).click();
//	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//	  driver.findElement(By.id("MainContent_ItemGv_SelectBtn_0")).sendKeys(sItemId);
	  
	  }
	  
	/*  @DataProvider 
	  public Object[]excelData() throws Exception{
	 	    return new Object[] {
	 	    		
	 	          ExcelUtils.getCellData(1, 1)
	 	        	
	 	    };
	 	
	  }*/
	  
}

