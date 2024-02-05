import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class TestKeyboardEvents {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\agarw\\Desktop\\Eclipse\\Selenium\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		
		driver.get("https://web-locators-static-site-qa.vercel.app/Auto-complete");
		
		WebElement search= driver.findElement(By.xpath("//*[@data-test='search-input']"));
		action.click(search).sendKeys("god").build().perform();
		
		WebElement result= driver.findElement(By.xpath("//li[3]/div"));
	
		action.moveToElement(result).click().build().perform();
		
		       
	    Thread.sleep(5000);
	    
	    driver.quit();
	}
}
