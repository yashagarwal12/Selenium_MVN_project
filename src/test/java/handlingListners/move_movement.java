package handlingListners;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

import io.github.bonigarcia.wdm.WebDriverManager;


public class move_movement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver webdriver = new ChromeDriver();
		
		EventFiringWebDriver driver = new EventFiringWebDriver(webdriver);
		
		weblisteners listner = new weblisteners();
		
		driver.register(listner);
		

		EventFiringMouse mouse = new EventFiringMouse(driver,listner);
		
		driver.navigate().to("http://google.com");
		
		Thread.sleep(3000L);
		
		Locatable hoverItem = (Locatable) driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[1]/a[3]"));
		
		Coordinates cord = hoverItem.getCoordinates();
		
		try{
			
			mouse.mouseMove(cord);
		}catch(Throwable t){
			
		}
		
		
		Thread.sleep(3000L);
		
}

}
