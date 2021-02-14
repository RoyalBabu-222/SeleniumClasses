package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;

		driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.close();

		driver = new FirefoxDriver();
		driver.get("https://www.icicibank.com");
		Thread.sleep(3000);
		driver.close();

		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "//Drivers//msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https:www.onlinesbi.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.close();

	}

}
