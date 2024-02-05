package handlingListners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class navigation_methods {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver = new FirefoxDriver();
		
		driver.navigate().to("http://google.com");
		
		driver.findElement(By.xpath("//*[@id='fll']/div[1]/a[2]")).click();
		
		Thread.sleep(2000L);
		
		driver.navigate().back();
		
		Thread.sleep(2000L);
		
		driver.navigate().forward();
		

	}

}
