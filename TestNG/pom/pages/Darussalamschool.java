package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Darussalamschool {
WebDriver driver;
String Url="http://www.darussalampublicschool.com";
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
public void verification1() {
	String Expectedtitle = "Darussalam Public School";
	String Actualtitle = driver.getTitle();
	if(Actualtitle.contentEquals(Expectedtitle)) {
		System.out.println("Title is confirmed as expected");
		System.out.println(true);
	}else {
		System.out.println("Title is not confirmed as expected");
		System.out.println(false);
	}
}
@Test(priority = 2)
public void verification2() {
	WebElement logo = driver.findElement(By.xpath("/html/body/header/div[1]/div/div[1]/div/a/img"));
	Boolean img= (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", logo);
	if(img) {
		System.out.println("Logo is Present");
		System.out.println(true);
	}else {
		System.out.println("Logo is not present");
		System.out.println(false);
	}
}
@Test(priority = 3)
public void verification3() {
	String ExpectedText = "DARUSSALAM PUBLIC SCHOOL";
	String ActualText = driver.getPageSource();
	if(ActualText.contains(ExpectedText)) {
		System.out.println("Text is verified");
		System.out.println(true);
	}else {
		System.out.println("Text is not verified");
		System.out.println(false);
	}
}
@Test(priority = 4)
public void testing() throws InterruptedException {
	WebElement About = driver.findElement(By.xpath("/html/body/header/div[3]/div/nav/ul/li[2]/a"));
	Actions Aboutclick = new Actions(driver);
	Aboutclick.moveToElement(About).build().perform();
	WebElement PrincipalMessage = driver.findElement(By.xpath("/html/body/header/div[3]/div/nav/ul/li[2]/ul/li[1]/a"));
	Aboutclick.moveToElement(PrincipalMessage).click().build().perform();
	String PageText = "Principals Message";
	String ActualText = driver.getPageSource();
	if(ActualText.contains(PageText)) {
		System.out.println("Page Text is verified");
	}else {
		System.out.println("Page Text is missing");
	}
	Thread.sleep(2000);
//	
//	
}
@Test(priority = 5)
public void testing2() {
	WebElement About = driver.findElement(By.xpath("/html/body/header/div[3]/div/nav/ul/li[2]/a"));
	Actions Aboutclick = new Actions(driver);
	Aboutclick.moveToElement(About).build().perform();
	WebElement Teachers = driver.findElement(By.xpath("/html/body/header/div[3]/div/nav/ul/li[2]/ul/li[2]/a"));
    Aboutclick.moveToElement(Teachers).click().build().perform();
}
@Test(priority = 6)
public void testing3() {
	WebElement Academic = driver.findElement(By.xpath("/html/body/header/div[3]/div/nav/ul/li[3]/a"));
	Actions Academicclick = new Actions(driver);
	Academicclick.moveToElement(Academic).build().perform();
	WebElement curriculam = driver.findElement(By.xpath("/html/body/header/div[3]/div/nav/ul/li[3]/ul/li[1]/a"));
	curriculam.click();

}
}
