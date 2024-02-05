package handlingScreenshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestAshot {
	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\agarw\\Desktop\\Eclipse\\Selenium_MVN_Project\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://demo.guru99.com/test/guru99home/");
		
		/*WebElement win=driver.findElement(By.xpath("//*[@id='post-17']/div/div/section[2]/div/div/div/section/div/div[1]/div"));
		
		System.out.println(win.getText());
		driver.findElement(By.xpath("//*[@id='post-17']/div/div/section[2]/div/div/div/section/div/div[1]/div/div[2]/div/div/a")).click();
		*/
		WebElement ele = driver.findElement(By.xpath("//*[@class='logo']"));
	
		//Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver, ele);
		//ImageIO.write(screenshot.getImage(), "PNG", new File(".\\screenshot\\"+"ashotimgelements.png"));
	
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot2);

		Point point = ele.getLocation();

		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "jpg", screenshot2);
		File screenshotLocation = new File(".\\screenshot\\"+fileName);
		FileUtils.copyFile(screenshot2, screenshotLocation);
	
		driver.quit();
	}

}
