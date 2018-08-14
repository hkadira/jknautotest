package scripts;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class SptTest {
String BaseURL = "https://spttest2.azurewebsites.net/";
private WebDriver driver;
protected String user = "prebera@dpssoftware.co.uk";
protected String pwd = "Enfield2019!";

  @Test
  public void sptLogin() {
	    By uName = By.xpath("//input[@name='loginfmt']");
	    waitForElemenet(uName);

		driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		
		By passwd = By.xpath("//input[@name='passwd']");
		waitForElemenet(passwd);
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		
		By btn = By.xpath("//input[@id='idBtn_Back']");
		waitForElemenet(btn);
		driver.findElement(By.xpath("//input[@id='idBtn_Back']")).click();
		
		
		By welcome = By.xpath("//dps-dashboard-layout//span[contains(text(),'Spitfire')]");
		waitForElemenet(welcome);
		Assert.assertEquals(driver.getTitle(), "Spitfire");
  }
  
  
  
  @BeforeClass
  public void beforeClass() {
	  //System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
	  ChromeDriverManager.getInstance().setup();
	  driver = new ChromeDriver();
	  driver.get(BaseURL);
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  //Thread.sleep(5000);
	  driver.close();
  }
  
  //Wait for element
 	public void waitForElemenet(By element) {
 		WebDriverWait waitO = new WebDriverWait(driver, 50);
 		WebElement elmOk = waitO.until(ExpectedConditions.elementToBeClickable(element));
 	}

}
