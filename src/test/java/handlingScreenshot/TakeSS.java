package handlingScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeSS {
public static WebDriver driver;
	public static void captureSS() throws IOException {
		Date d=new Date();
		String filename=d.toString().replace(":","_").replace(" ","_")+".jpg";
	File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File location=new File(".//screenshot//"+filename);
		FileUtils.copyFile(screenshot,location);
	}
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		WebElement frame=driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));
		driver.switchTo().frame(frame);
		captureSS();
	}

}
