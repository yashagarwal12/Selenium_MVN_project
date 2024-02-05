package assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ClearTrip {

	public static void main(String[] args) throws InvalidFormatException,EncryptedDocumentException,InterruptedException, IOException {

		//-----Getting data from excel file------
		File file=new File("C:\\Users\\agarw\\Desktop\\Eclipse\\Cleartrip.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook xwb=new XSSFWorkbook(fis);
		XSSFSheet xws=xwb.getSheetAt(0);
		Row row=xws.getRow(0);
		Cell cell1=row.getCell(0);
		String cityA=cell1.getStringCellValue();
		Cell cell2=row.getCell(1);
		String cityB=cell2.getStringCellValue();
		
		//-----Initializing driver--------
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.cleartrip.com/flights");
		
		driver.findElement(By.xpath("//p[text()='Round trip']")).click();
		
		//-------Getting City 1--------------
		driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div[1]/input[1]")).clear();
		driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(cityA);
		Thread.sleep(1000);

		WebElement city1 = driver.findElement(By.xpath("//div[3]/div[1]/div[1]/div/div/div[2]"));
		List<WebElement> originOptions = city1.findElements(By.tagName("li"));
		originOptions.get(0).click();

		//--------Getting city2--------------
		driver.findElement(By.xpath("//div[5]/div[1]/div[1]/div[1]/input[1]")).clear();
		driver.findElement(By.xpath("//div[5]/div[1]/div[1]/div[1]/input[1]")).sendKeys(cityB);
		Thread.sleep(2000);
		WebElement city2 = driver.findElement(By.xpath("//div[3]/div[1]/div[5]/div/div/div[2]"));
		List<WebElement> originOptions2 = city2.findElements(By.tagName("li"));
		originOptions2.get(0).click();
		
		//--------Getting date1--------------
		driver.findElement(By.xpath("//div[1]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='Wed Nov 24 2021']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Wed Nov 24 2021']")).click();
		Thread.sleep(2000);
		
		//Getting date2----------------------
		driver.findElement(By.xpath("//div[1]/button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='Wed Dec 01 2021']")).click();
		Thread.sleep(1000);
		
		//------Getting number of adult passengers-------------
		Select dropdown = new Select(driver.findElement(By.xpath("//div[1]/select[1]")));
		dropdown.selectByValue("2");
		
		//-----Search flight-----------------
		driver.findElement(By.xpath("//button[text()='Search flights']")).click();
		Thread.sleep(5000);
		
		//-----Taking Screenshot------
		Date d = new Date();
		String sdf = d.toString().replace(":","_").replace(" ", "_");
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg", new File(".//screenshot//"+sdf+".jpg"));
		driver.quit();
	}
}
