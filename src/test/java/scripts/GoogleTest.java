package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class GoogleTest {
private final String BASE_URL = "https://www.google.lk/";
private WebDriver driver;	
	
  @Test(enabled = true , priority = 1 , groups = "smoke")
  public void search() {
	  driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.name("btnK")).click();
  }
  
  @Test(enabled = true , priority = 2)
  public void page() {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
  }
  
    @BeforeClass(groups = "smoke")
	public void beforeClass() {
		//System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
    	
    	ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get(BASE_URL);
	}

	@AfterClass(groups = "smoke")
	public void afterClass() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();
	}
  
}
