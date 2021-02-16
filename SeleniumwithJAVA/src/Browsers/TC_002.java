package Browsers;

import org.apache.log4j.Logger;

public class TC_002 extends BaseClass{
	
	int a =10, b = 20, c = 30, d = 40;
	private static final Logger log = Logger.getLogger(TC_002.class);
	
	public static void main(String[] args) throws Exception {
		
		init();
		log.info("***TEST CASE STARTED***");
		log.info("Loading Property files & configuration files");
		
		openBrowser("chromebrowser");
		log.info("Browser opened "+p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url "+childp.getProperty("amazonurl"));
		
        windowMaximize();
        log.info("Window maximized");
        
		cookiesDelete();
		log.info("Cookies Deleted");
		
		String title = getTitlePage();
		System.out.println(title);
		
		String url = getcurrentUrl();
		System.out.println(url);
		
		selectOption("amazondropdown_id", "Electronics");
		log.info("Selected the option \"Electronics\" using the locator: "+orp.getProperty("amazondropdown_id"));
		
		typeText("amazontextfield_id", "iphonexr");
		log.info("Text entered \"iphonexr\" using the locator: "+orp.getProperty("amazontextfield_id"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on Search button using the locator: "+orp.getProperty("amazonsearchbutton_xpath"));
		
		waitforElement(2000);
		closeBrowser();
		log.info("Browser closed");
		
	}

}
