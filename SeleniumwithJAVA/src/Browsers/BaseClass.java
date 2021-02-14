package Browsers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class BaseClass {

	// Global declarations
	public static WebDriver driver = null;
	public static String projectpath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties parentp;
	public static Properties childp;
	public static Properties orp;

	// Method to initialize browsers
	public static void init() throws IOException {

		fis = new FileInputStream(projectpath + "//Data.properties");
		p = new Properties();
		p.load(fis);

		fis = new FileInputStream(projectpath + "//env.properties");
		parentp = new Properties();
		parentp.load(fis);
		String e = parentp.getProperty("environment");
		System.out.println(e);

		fis = new FileInputStream(projectpath + "//"+e+".properties");
		childp = new Properties();
		childp.load(fis);
//		String url = childp.getProperty("amazonurl");
//		System.out.println(url);

		fis = new FileInputStream(projectpath + "//or.properties");
		orp = new Properties();
		orp.load(fis);
		
		fis = new FileInputStream(projectpath+ "//log4jconfig.properties");
		PropertyConfigurator.configure(fis);

	}

	public static void openBrowser(String Browser) {

		if (p.getProperty(Browser).equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectpath + "//Drivers//chromedriver.exe");

			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("user-data-dir=C:\\Users\\royal\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
			opt.addArguments("--disable-notifications");

			driver = new ChromeDriver(opt);
		} else if (p.getProperty(Browser).equals("ff")) {
			System.setProperty("webdriver.gecko.driver", projectpath + "//drivers//geckodriver.exe");

			ProfilesIni pi = new ProfilesIni();
			FirefoxProfile profile = pi.getProfile("FirefoxProfile");
			profile.setPreference("dom.webnotifications.enabled", false);

			FirefoxOptions opt = new FirefoxOptions();
			opt.setProfile(profile);

			driver = new FirefoxDriver(opt);

		}

	}

	public static void navigateUrl(String url) {
		driver.get(childp.getProperty(url));
	}

	public static String getcurrentUrl() {
		return driver.getCurrentUrl();
	}

	public static String getTitlePage() {
		return driver.getTitle();
	}

	public static void cookiesDelete() {
		driver.manage().deleteAllCookies();
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static void waitforElement(int milliSeconds) throws Exception {
		Thread.sleep(milliSeconds);
	}

	public static void browserRefresh() {
		driver.navigate().refresh();
	}

	public static void browserForward() {
		driver.navigate().forward();
	}

	public static void browserBack() {
		driver.navigate().back();
	}

	public static void closeBrowser() {
		driver.quit();
	}
	
	public static WebElement getelement(String locatorKey) {
		
		WebElement element = null;
		
		if(locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(orp.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(orp.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_classname")) {
			element = driver.findElement(By.className(orp.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orp.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_cssselector")) {
			element = driver.findElement(By.cssSelector(orp.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orp.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(orp.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_tagname")) {
			element = driver.findElement(By.tagName(orp.getProperty(locatorKey)));
		}
		return element;
		
	}
	
	
	public static void clickElement(String locatorKey) {
		getelement(locatorKey).click();
	}
	
	public static void typeText(String locatorKey, String text) {
		getelement(locatorKey).sendKeys(text);
	}
	
	public static void selectOption(String locatorKey, String option) {
		getelement(locatorKey).sendKeys(option);
	}

}
