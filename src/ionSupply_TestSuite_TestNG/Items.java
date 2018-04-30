package ionSupply_TestSuite_TestNG;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import ionSupply_TestSuite_TestNG.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Items {
	
	public WebDriver driver;
	 public Actions builder;
	 
	 
	 @BeforeSuite    
	  public void beforeSuite() {
		 
		  driver = new FirefoxDriver();
		  driver.get("http://localhost/TestApp/Pages/ItemReport.aspx");
		  driver.manage().window().maximize();
		  
		  }
	 
	 @AfterSuite
	 public void afterSuite() {
		 driver.quit();
	 }
	 
  @Test(dataProvider = "Items_dp")
  public void UpdateDescription(String ItemDesc) {
	  driver.findElement(By.id("MainContent_ItemsTypeGv_SelectBtn_6")).click();
	  driver.findElement(By.id("MainContent_btnEditItem")).click();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  driver.findElement(By.id("MainContent_ItemDescriptionTxt")).clear();
	  driver.findElement(By.id("MainContent_ItemDescriptionTxt")).sendKeys(ItemDesc);
	  driver.findElement(By.id("MainContent_btnItemSubmit")).click();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  driver.findElement(By.id("MainContent_btnMdlClose")).click();
	  String CurrentItemDesc = driver.findElement(By.id("MainContent_ItemsTypeGv_ItemDescLbl_6")).getText();
	  Assert.assertTrue(CurrentItemDesc.contains(ItemDesc));
  }

  
  
  @DataProvider
  public Object[][]Items_dp() throws Exception {
	  return new Object[][] {
		  new Object[] { ExcelUtils.getCellData(0,0)},
		  new Object[] { ExcelUtils.getCellData(1,0)},
		  new Object[] { ExcelUtils.getCellData(2,0)},
		  new Object[] { ExcelUtils.getCellData(3,0)},
		  new Object[] { ExcelUtils.getCellData(4,0)},
		  new Object[] { ExcelUtils.getCellData(5,0)},
		  new Object[] { ExcelUtils.getCellData(6,0)},
		  new Object[] { ExcelUtils.getCellData(7,0)},
		  new Object[] { ExcelUtils.getCellData(8,0)},
		  new Object[] { ExcelUtils.getCellData(9,0)},
		  new Object[] { ExcelUtils.getCellData(10,0)},
	
    };
  }
}
