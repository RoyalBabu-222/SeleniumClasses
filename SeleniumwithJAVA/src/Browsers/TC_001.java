package Browsers;

public class TC_001 extends BaseClass{

	public static void main(String[] args) throws Exception {

		
		init();
		openBrowser("chromebrowser");
		navigateUrl("amazonurl");
        windowMaximize();
		
		cookiesDelete();
		
		String title = getTitlePage();
		System.out.println(title);
		
		String url = getcurrentUrl();
		System.out.println(url);
	
		browserBack();
		waitforElement(4000);
		browserForward();
		waitforElement(4000);
		browserRefresh();
			
		closeBrowser();
		
		
		
	}

}
