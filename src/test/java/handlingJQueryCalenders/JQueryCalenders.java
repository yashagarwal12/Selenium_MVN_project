package handlingJQueryCalenders;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryCalenders {

	static int targetDay = 0,
			targetMonth = 0,
			targetYear = 0;
	
	static int currentDay = 0,
			currentMonth = 0,
			currentYear = 0;
	
	static int jumpMonthsBy=0;
	
	static boolean increment = true;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		String dateToSet= "14/03/2022";
		
		//get current date
		getCurrentDateMonthAndYear();
		System.out.println(currentDay+"   "+currentMonth+"   "+currentYear);
		
		//get target date
		GetTargetDateMonthAndYear(dateToSet);
		System.out.println(targetDay+"   "+targetMonth+"   "+targetYear);
		
		
		//Get Jump month
		CalculateHowManyMonthsToJump();
		System.out.println(jumpMonthsBy);
		System.out.println(increment);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement frame=driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);

		driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();
		Thread.sleep(1000);
		for(int i=0;i<jumpMonthsBy;i++) {
		if(increment) {
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
		}
		else {
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
		}
		Thread.sleep(1000);
		}
		driver.findElement(By.linkText(Integer.toString(targetDay))).click();
		
		
	}
	
	public static void getCurrentDateMonthAndYear(){
		
		Calendar cal = Calendar.getInstance();
		
		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH)+1;
		currentYear = cal.get(Calendar.YEAR);
	}
	
	
	public static void GetTargetDateMonthAndYear(String dateString)
	{
		
		int firstIndex = dateString.indexOf("/");
		int lastIndex = dateString.lastIndexOf("/");
		
		String day = dateString.substring(0, firstIndex);
		targetDay = Integer.parseInt(day);
		
		
		String month = dateString.substring(firstIndex+1, lastIndex);
		targetMonth = Integer.parseInt(month);
		
		
		String year = dateString.substring(lastIndex+1, dateString.length());
		targetYear = Integer.parseInt(year);
		
	}
	
	public static void CalculateHowManyMonthsToJump(){
		
		if((targetMonth-currentMonth)>0 && (targetYear-currentYear)==0){
			
			jumpMonthsBy = (targetMonth-currentMonth);
			
		}else if((currentMonth-targetMonth)>0 && (targetYear-currentYear)==0) {
			jumpMonthsBy = (currentMonth-targetMonth);
			increment = false;
			
		}else if((targetYear-currentYear)>0) {
			jumpMonthsBy=Math.abs((12-currentMonth)+targetMonth);
			
		}else if((targetYear-currentYear)<0) {
			jumpMonthsBy=Math.abs((12-targetMonth)+currentMonth);
			increment=false;
		}
		
	}
}
