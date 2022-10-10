package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Expedia_page {
WebDriver driver;

By flights = By.xpath("//*[@id=\"wizardMainRegion\"]/div/div/div/div/ul/li[2]/a/span");
By travellers = By.xpath("//*[@id=\"adaptive-menu\"]/button");
By childs = By.xpath("//*[@id=\"child-age-input-0-0\"]");
By Classoption = By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/div[2]/button");
public Expedia_page(WebDriver driver){
	this.driver=driver;
}
public void setvalues(String Origin,String Destination) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	driver.findElement(flights).click();
	driver.findElement(travellers).click();
	driver.findElement(By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/section/div[1]/div[1]/div/button[2]/span/svg")).click();
	driver.findElement(By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/section/div[1]/div[2]/div/button[2]/span/svg/svg/path")).click();
	
	WebElement childrange = driver.findElement(childs);
	Select agelist = new Select(childrange);
	agelist.selectByIndex(2);
	driver.findElement(By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/div[2]/button")).click();
	
	WebElement classoption = driver.findElement(Classoption);
	classoption.click();
	driver.findElement(By.xpath("//*[@id=\"preferred-class-input\"]/div/div/a[4]/span")).click();
	
}
}
