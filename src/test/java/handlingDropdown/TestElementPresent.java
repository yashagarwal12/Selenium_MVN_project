package handlingDropdown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestElementPresent {
	public static WebDriver driver;
	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}catch(Exception E){
			return false;
		}
	}
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		System.out.println(isElementPresent(By.id("searchLanguage")));
	}
}
