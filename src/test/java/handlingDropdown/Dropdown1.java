package handlingDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//-----selecting a value from dropdown-------
		
		/*driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.findElement(By.name("country")).sendKeys("American Samoa");
		 */
		
		//-----selecting from dropdown using select class-------
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		WebElement element1=driver.findElement(By.id("searchLanguage"));
		Select select=new Select(element1);
		select.selectByValue("hi");
		System.out.println(select.getOptions().get(0).getText());
		
		//-----getting all option element-------------
		List<WebElement> element=element1.findElements(By.tagName("option"));
		System.out.println(element.size());
		for(int i=0;i<element.size();i++)
		System.out.println(element.get(i).getAttribute("lang"));
		System.out.println();
		
		
		//------getting links count and it's data---------
		WebElement block=driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[11]/div[3]"));
		List<WebElement> links=block.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int j=0;j<links.size();j++) {
			System.out.println(links.get(j).getText()+"	 "+links.get(j).getAttribute("href"));
		}
		

	}

}
