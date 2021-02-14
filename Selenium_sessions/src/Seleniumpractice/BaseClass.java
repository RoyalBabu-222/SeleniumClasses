package Seleniumpractice;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass 
{
	
	public static String path = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;

	public static void init() throws Exception 
	{
	
		fis = new FileInputStream(path + "//data.properties");
		p = new Properties();
		p.load(fis);
		
	}
	
	
}
