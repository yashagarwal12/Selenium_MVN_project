import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleTabsAndPopups {

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.driver","C:\\Users\\agarw\\Desktop\\Eclipse\\Selenium\\chromedriver.exe");
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				ChromeDriver driver = new ChromeDriver(options);
				WebDriverWait wait=new WebDriverWait(driver,5);
		
		     driver.get("https://www.naukri.com/");
		    driver.manage().window().maximize();
		
	String parentframe=driver.getWindowHandle();
	
	driver.findElement(By.cssSelector("a[title=Remote]")).click();
	driver.switchTo().window(parentframe);
	wait.until(ExpectedConditions.urlToBe("https://www.naukri.com/"));
	Thread.sleep(10000);
	
	int maxAttempts = 3; // Maximum number of times you want to retry

    int attempt = 1;
    boolean elementClickable = false;

    while (attempt <= maxAttempts) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@title='Analytics']"))));
            element.click(); // Click the element once it becomes clickable

            elementClickable = true; // Set the flag to indicate it was clicked

            break; // Break the loop since the action was successful

        } catch (Exception e) {
            // Not clickable, maybe retry?

            attempt++; // Increment the attempt count

        }
    }

    if (!elementClickable) {
        System.out.println("Element was not clickable after " + maxAttempts + " attempts. Try a different strategy?");
    }
	driver.switchTo().window(parentframe);
	wait.until(ExpectedConditions.urlToBe("https://www.naukri.com/"));
	driver.findElement(By.xpath("//a[@title='Fresher']")).click();
	
	Set<String> win=driver.getWindowHandles();
	Iterator<String> itr=win.iterator();
	
	while(itr.hasNext()) {
		String wind=itr.next();
		if(!wind.equals(parentframe)) {
		driver.switchTo().window(wind);
		System.out.println(driver.getTitle());
		driver.close();
		}
		driver.switchTo().window(parentframe);
	}
	Thread.sleep(3000);
	System.out.println(win.size());
	
		 /*driver.get("https://demo.guru99.com/popup.php");			
	        driver.manage().window().maximize();		
	                		
	driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();			
	        		
	        String MainWindow=driver.getWindowHandle();		
	        		
	        // To handle all new opened window.				
	            Set<String> s1=driver.getWindowHandles();		
	        Iterator<String> i1=s1.iterator();		
	        		
	        while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            		
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            {    		
	                 
	                    // Switching to Child window
	                    driver.switchTo().window(ChildWindow);	                                                                                                           
	                    driver.findElement(By.name("emailid"))
	                    .sendKeys("gaurav.3n@gmail.com");                			
	                    
	                    driver.findElement(By.name("btnLogin")).click();			
	                                 
				// Closing the Child Window.
	                        driver.close();		
	            }		
	        }		
	        // Switching to Parent window i.e Main Window.
	        driver.switchTo().window(MainWindow);
	        
	 */   
	driver.quit();
	}

}
