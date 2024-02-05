package assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.name("country")).sendKeys("Germany");
		driver.findElement(By.name("city")).sendKeys("Agra");
		driver.findElement(By.name("name")).sendKeys("Yash");
		WebElement div=driver.findElement(By.className("span_1_of_4"));
		List<WebElement> button=div.findElements(By.tagName("input"));
		for(WebElement btn:button) {
			if(btn.getAttribute("type")=="submit") {
				btn.click();
			}
		}
		 driver.close();
	}
}
