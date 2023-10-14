package SeleniumUI;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MainSelenium {
	WebDriver driver;
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;
	
  @Test(dataProvider = "dp")
  public void assessment(String user1,String pass1,String firstname,String lastname,String zip) throws InterruptedException {
	  driver.get("https://www.saucedemo.com/");
	  test=extent.createTest("Launch Browser, login saucedemo and add one item to cart and continue and logout");
	  
	  String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	  String screenshot="Screenshot"+timestamp+".png";
		
	  SeleniumPOM obj1=new SeleniumPOM(driver);
	  
	  obj1.login(user1, pass1);
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File sourcefile=ts.getScreenshotAs(OutputType.FILE);
	  File destfile=new File("C:\\Users\\KIIT\\Downloads\\core-wave2-automation-immersive-final-main\\Screenshot"+screenshot);
	  try {
		  FileUtils.copyFile(sourcefile, destfile);
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  test.pass("login success");
	  
	  obj1.adding_to_cart();
	  test.pass("adding to cart is success");
	  
	  obj1.address(firstname, lastname, zip);
	  test.pass("completed all and logout done");
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  extent.flush();
  }


  @DataProvider
  public Object[][] dp() throws IOException {
String[][] data=new String[2][5];
	  
	  File file=new File("C:\\Users\\KIIT\\Downloads\\core-wave2-automation-immersive-final-main\\inputdata.xlsx");
	  FileInputStream fis=new FileInputStream(file);
	  XSSFWorkbook workbook=new XSSFWorkbook(fis);
	  XSSFSheet sheet=workbook.getSheetAt(0);
	  int rowcount=sheet.getPhysicalNumberOfRows();
	  System.out.println("row count:"+rowcount);
	  
	  for(int i=0;i<rowcount;i++)
	  {
		 
		  data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
		  data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
		  data[i][2]=sheet.getRow(i).getCell(2).getStringCellValue();
		  data[i][3]=sheet.getRow(i).getCell(3).getStringCellValue();
		  DecimalFormat df=new DecimalFormat("#");
		  data[i][4]= df.format(sheet.getRow(i).getCell(4).getNumericCellValue());
	  }
	    
	 
	  return data;
  }
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  extent=new ExtentReports();
	  spark=new ExtentSparkReporter("./UIAutomationAssessment/Report/extent_report.html");
	  extent.attachReporter(spark);
  }

  @AfterSuite
  public void afterSuite() {
  }

}
