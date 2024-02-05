package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.get("https://google.com");
    Dimension height=driver.manage().window().getSize();
    Dimension start_size=new Dimension(height.height/4,height.width/4);
    driver.manage().window().setSize(start_size);
    Dimension end_size=new Dimension(height.height*4,height.width*4);
    driver.manage().window().setSize(end_size);
}
}
