
package handlingListners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class testGoogle_ajax {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new FirefoxDriver();
		
		driver.get("http://google.com");
		
		driver.findElement(By.xpath("//*[@id='gbqfq']")).sendKeys("Selenium");
		
		Thread.sleep(3000L);
		
		int x = 1;
		
		try{
			
		while(true){
			
			String value = driver.findElement(By.xpath("//*[@id='gsr']/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr["+x+"]/td/div/table/tbody/tr/td[1]/span")).getText();
			System.out.println(value);
			x++;}
		}catch(Throwable t){
			
			System.out.println("end of the list");
		}}
		
		
		

	}


