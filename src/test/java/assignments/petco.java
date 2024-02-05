package assignments;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class petco {
public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.petco.com/");
	WebElement box=driver.findElement(By.xpath("//*[@id=\"bx-step-1501359-1\"]"));
	new Actions(driver).moveToElement(box);
	driver.findElement(By.xpath("//*[@id=\"bx-element-1501359-Kcqocxv\"]/button")).click();
	
	WebElement category=driver.findElement(By.xpath("//*[@id=\"topcontent\"]/div[3]/button"));
	category.click();
	driver.findElement(By.xpath("//*[@id=\"topcontent\"]/div[3]/div/div/ul/li[4]/button")).click();
	driver.findElement(By.xpath("//*[@id=\"topcontent\"]/div[3]/div/div/ul/li[4]/div[3]/ul/section/div[2]/ul/li[3]/div[3]/ul/li[1]/a")).click();
	WebElement sort=driver.findElement(By.xpath("//*[@id=\"sort_by\"]"));
	Select select=new Select(sort);
	select.selectByVisibleText("Name A-Z");
	driver.findElement(By.id("price-header")).click();
	driver.findElement(By.xpath("//*[@id=\"price-panel\"]/div/div/div[3]/label/span")).click();
	new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[3]/div/section/div[5]/ul[1]/li[1]/div")));
	new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[3]/div/section/div[5]/ul[1]/li[1]/div/div[2]")));
	String ele=driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[3]/div/section/div[5]/ul[1]/li[1]/div/div[2]/div[1]/a")).getText();
	System.out.println(ele);
	
	File file=new File("C:\\Users\\agarw\\Desktop\\Eclipse\\petco.xls");
	FileOutputStream fos=new FileOutputStream(file);
	XSSFWorkbook book=new XSSFWorkbook();
	XSSFSheet sheet=book.createSheet("Sheet1");
	Row row=sheet.createRow(0);
	Cell cell=row.createCell(0);
	cell.setCellValue(ele);
	book.write(fos);
	book.close();
	Date d = new Date();
	String sdf = d.toString().replace(":","_").replace(" ", "_");
	/*Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
	ImageIO.write(screenshot.getImage(), "jpg", new File(".//screenshot//"+sdf+".jpg"));*/
	File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File location=new File(".//screenshot//"+sdf+".jpg");
	FileUtils.copyFile(screenshot,location);
	WebElement logo=driver.findElement(By.xpath("//*[@id=\"petco-header-render-node\"]/header/div[3]/div/a"));

	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();", logo); 
	new Actions(driver).moveToElement(logo).click().perform();
	driver.quit();
}
}
