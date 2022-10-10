package interview;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ebay {
WebDriver driver;
String EbayUrl = "https://www.ebay.com/";

@BeforeTest
public void start() {
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
}
@BeforeMethod
public void url() {
	driver.manage().window().maximize();
    driver.get(EbayUrl);
}
@Test(priority = 1)
public void ebay_Homepage() {
	System.out.println(driver.getCurrentUrl());
	String ActualTitle = driver.getTitle();
	String Expected_Title = "ebay.com";
	if(ActualTitle.contains(Expected_Title)) {
		System.out.println("Page title is confirmed");
	}else {
		System.out.println("Page Title is not Confirmed"+ " Actual Title is:" +ActualTitle);
	}
	String PageSource = driver.getPageSource();
	String Pagetext = "Daily Deals";
	if(PageSource.contains(Pagetext)) {
		System.out.println("Page contains the text");
	}else {
		System.out.println("Page not contains the Text");
	}
	boolean logoPresent = driver.findElement(By.xpath("//*[@id=\"gh-logo\"]")).isDisplayed();
	if(logoPresent == true) {
		System.out.println("Logo is present");
	}else {
		System.out.println("Logo is not present");
	}

}
@Test(priority = 2)
public void search() throws InterruptedException {
	
    WebElement Search = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
    Search.sendKeys("home theaters");
    driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
    driver.navigate().back();
    Thread.sleep(2000);

    WebElement electronics = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
    Actions act = new Actions(driver);
    act.moveToElement(electronics).perform();
    Thread.sleep(1000);
    WebElement ComputersAndTablets = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[1]/ul/li[3]/a"));
    act.moveToElement(ComputersAndTablets).click().build().perform();
    
  JavascriptExecutor js = (JavascriptExecutor)driver;
  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
  Thread.sleep(2000);
  
  driver.navigate().back();
  driver.get("https://demo.guru99.com/popup.php");
  String currentwindow = driver.getWindowHandle();
  System.out.println("Parent window title " +driver.getTitle());
  WebElement item1 = driver.findElement(By.xpath("/html/body/p/a"));
  item1.click();
  Set<String> allwindow = driver.getWindowHandles();
  
  for(String windowhandle : allwindow) {
	  System.out.println(allwindow);
	  if(!windowhandle.equalsIgnoreCase(currentwindow)) {
		  driver.switchTo().window(windowhandle);
		
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys("demsskara@yahoomail.com");
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")).click();
	  }
	  driver.switchTo().window(currentwindow);
	  driver.navigate().to(EbayUrl);
  }
 
    
//System.out.println("Parent window title "+driver.getTitle());

    
}
}
