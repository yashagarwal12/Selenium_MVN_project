package handlingListners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class test_listeners {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver webdriver = new ChromeDriver();
		
		EventFiringWebDriver driver = new EventFiringWebDriver(webdriver);
		
		weblisteners listner = new weblisteners();
		
		driver.register(listner);
		
		

		driver.navigate().to("http://google.com");
		
		
		
		
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[1]/a[1]")).click();
		
		Thread.sleep(2000L);
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//html/body/div[1]/div[5]/div[2]/div[1]/a[3]")).click();
		
		Thread.sleep(2000L);
		
		driver.navigate().back();
		
		Thread.sleep(2000L);
		
		driver.navigate().forward();
		
	}

}
