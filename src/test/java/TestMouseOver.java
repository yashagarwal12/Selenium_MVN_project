import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;



public class TestMouseOver {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\agarw\\Desktop\\Eclipse\\Selenium\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://web-locators-static-site-qa.vercel.app/Mouse");
		driver.manage().window().maximize();
		
		WebElement dnd=driver.findElement(By.xpath("//*[text()='Drag me around']"));
		WebElement dnd2=driver.findElement(By.xpath("//*[text()='Drag me to target']"));
		WebElement dnd23=driver.findElement(By.xpath("//div[contains(@class,'drop-target')]"));
		
		Actions action=new Actions(driver);
		action.moveToElement(dnd).dragAndDropBy(dnd, 125, 125).perform();
		action.moveToElement(dnd23).dragAndDrop(dnd2, dnd23).perform();
		
		WebElement table=driver.findElement(By.xpath("//*[@class='spectrum-Table-cellContents_d0fc74']"));
		action.moveToElement(table).click().perform();
		
		WebElement dnd4=driver.findElement(By.xpath("//*[@aria-rowindex='NaN']/div[@title=':::' and @aria-colindex='1']"));
		action.moveToElement(dnd4).click().dragAndDropBy(dnd4, 0, 30).build().perform();
		
	}

}
