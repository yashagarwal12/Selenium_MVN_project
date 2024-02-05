import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;



public class TestSliders {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\agarw\\Desktop\\Eclipse\\Selenium\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	ChromeDriver driver = new ChromeDriver(options);
	
	//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.get("https://jqueryui.com/resources/demos/slider/default.html");
	driver.manage().window().maximize();
	WebElement slider=driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
    new Actions(driver).dragAndDropBy(slider, 100, 0).perform();
}
}
