package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Expedia_page;

public class Expedia_tests {
WebDriver driver;
String Expediaurl= "https://www.expedia.co.in/";
@BeforeTest
public void start() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();

}
@BeforeMethod
public void open() {
	driver.manage().window().maximize();
	driver.get(Expediaurl);
	
}
@Test
public void testexpedia() {
	Expedia_page object = new Expedia_page(driver);
	
}
}
