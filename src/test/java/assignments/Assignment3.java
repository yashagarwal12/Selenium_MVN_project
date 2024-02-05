package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"pollform\"]/table/tbody/tr[2]/td/input[2]")).click();
		String str=driver.findElement(By.id("mathq2")).getText();
		System.out.println(str);
		/*for(int i=0;i<str.length();i++)
		System.out.println(str.charAt(i));
		String[] str1=str.split(" ");
		System.out.println(str1);
		int a=Integer.parseInt(str1[0]);
		int b=Integer.parseInt(str1[2]);
		int c;
		c=a+b;
		System.out.println(c);
		String str2=String.valueOf(c);
		driver.findElement(By.id("mathuserans2")).sendKeys(str2);*/
		String str1=str.replace("=", "");
		System.out.println(str1);
		int num=0;
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i)=='+') {
			num=i;
		}
}
		String num1=str1.substring(0,num);
		num1=num1.trim();
		System.out.println(num1);
		String num2=str1.substring(num+1);
		num2=num2.trim();
		System.out.println(num2);
		int a=Integer.parseInt(num1);
		int b=Integer.parseInt(num2);
		int c;
		c=a+b;
		System.out.println(c);
		String str2=String.valueOf(c);
		driver.findElement(By.id("mathuserans2")).sendKeys(str2);
		driver.quit();
		
	}
	}
