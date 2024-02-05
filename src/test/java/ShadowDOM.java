import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShadowDOM {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\agarw\\Desktop\\Eclipse\\Selenium\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	ChromeDriver driver = new ChromeDriver(options);
	
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get("chrome://downloads/");
	
	WebElement root = driver.findElement(By.cssSelector("downloads-manager"));
	
	WebElement shadowRoot1 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",root);

	WebElement root2 = shadowRoot1.findElement(By.cssSelector("downloads-toolbar"));
	WebElement shadowRoot2 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",root2);

	WebElement root3 = shadowRoot2.findElement(By.cssSelector("cr-toolbar"));
	WebElement shadowRoot3 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",root3);

	
	WebElement root4 = shadowRoot3.findElement(By.cssSelector("cr-toolbar-search-field"));
	WebElement shadowRoot4 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",root4);
	shadowRoot4.findElement(By.cssSelector("#searchInput")).sendKeys("Hello");
			}
}
