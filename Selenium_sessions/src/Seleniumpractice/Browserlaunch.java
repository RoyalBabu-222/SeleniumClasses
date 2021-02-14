package Seleniumpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browserlaunch 
{

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriver driver = null;
		
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		//System.out.println(driver.getPageSource());
		
		
		Thread.sleep(2000);
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com");
		
		Thread.sleep(2000);
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//Drivers//msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://www.facebook.com");
		
		driver.quit();
		
	}
	

}
