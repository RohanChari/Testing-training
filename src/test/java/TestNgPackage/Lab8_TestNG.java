package TestNgPackage;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Lab8_TestNG {
  WebDriver driver;
	
  @Test(dataProvider = "dp")
  
  
  public void f(String  email, String password) throws InterruptedException {
	  
	   
		driver.findElement(By.linkText("My Account")).click();
	    driver.findElement(By.partialLinkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
		
		/*WebElement ele=driver.findElement(By.linkText("Desktops"));
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Mac (1)")).click();
		
		Select show = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
	    show.selectByIndex(1);
	    JavascriptExecutor js1 =(JavascriptExecutor)driver;
	    js1.executeScript("window.scrollBy(0,500)");*/
	    
	    /*driver.findElement(By.linkText("iMac")).click();
	    
	    JavascriptExecutor js2 =(JavascriptExecutor)driver;
	    js2.executeScript("window.scrollBy(0,200)");
	    driver.findElement(By.id("button-cart")).click();
	    
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,1000)");
	     driver.findElement(By.linkText("iMac")).click();*/
	    
	    driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();
        Select s1=new Select(driver.findElement(By.id("input-sort")));
        List<WebElement> l1 =s1.getOptions();
        s1.selectByIndex(1);
        Thread.sleep(1000);
        
        
        JavascriptExecutor js=(JavascriptExecutor)driver;  
        js.executeScript("window.scrollBy(0,900);");
       
        
        driver.findElement(By.xpath("//*[@id=\"product-list\"]/div/form/div/div[1]/a/img")).click();
        
        JavascriptExecutor js1=(JavascriptExecutor)driver;  
        js1.executeScript("window.scrollBy(0,500);");
        Thread.sleep(1000);
        driver.findElement(By.id("button-cart")).click();
        
               
        //JavascriptExecutor js2=(JavascriptExecutor)driver;  
        //js2.executeScript("window.scrollBy(0,900);");
        
        
   
           
				
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	    
	 
	    WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
  }

 
  
  @AfterMethod
  public void afterMethod() {
  }


  
  
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "tst@gmail.com", "Vivanta" },
      
    };
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
  }

  @AfterSuite
  public void afterSuite() {
  }

}
