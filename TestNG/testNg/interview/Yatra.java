package interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Yatra {
	WebDriver driver;
	String Url=" https://www.wappalyzer.com";
@BeforeTest
public void url() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
@BeforeMethod
public void start() {
	driver.manage().window().maximize();
	driver.get(Url);	
   }
@Test(priority = 1)
public void wappalyzer1() throws InterruptedException {
	WebElement resources = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[1]/header/div/div/div/div[2]/button[2]/span"));
    resources.click();
    WebElement technologies = driver.findElement(By.xpath("//*[@id=\"list-item-49\"]/div/div[1]"));
    technologies.click();
    Thread.sleep(2000);
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("window.scrollBy(4,document.body.scrollHeight)");
   
    WebElement techsearch = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/input"));
    JavascriptExecutor j = (JavascriptExecutor)driver;
    j.executeScript ("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", techsearch);
    Actions act = new Actions(driver);
    act.moveToElement(techsearch);
    act.click().build().perform();
    
    WebElement dropname= driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/form/div/div/div/div[1]/input"));
    dropname.sendKeys("wordpress");
    driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div/div[1]")).click();
//    Select dropdown = new Select(dropname);
//    dropdown.selectByIndex(0);
}
@Test(priority = 2)
public void wappalyzer2() {
	WebElement Products = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[1]/header/div/div/div/div[2]/button[1]/span"));
	Products.click();
	driver.findElement(By.xpath("//*[@id=\"list-item-22\"]/div[2]/div[1]")).click();
}
}
