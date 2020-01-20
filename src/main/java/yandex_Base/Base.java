package yandex_Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.apache.commons.io.FileUtils;

public class Base {

	//Below i have declared static global variables
	public static Properties prop;
	public static FileInputStream ip;
	public static WebDriver driver;
	public static String  osName=System.getProperty("os.name");
	public static String userDir = System.getProperty("user.dir");
	
	
	//Below is the code for initializing the property file written in constructor

	public Base() throws IOException {

		prop = new Properties();

		try {
			ip = new FileInputStream(userDir+"\\src\\main\\java\\yandex_PropertyFile\\yandexProp.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop.load(ip);

	}
	//Below is the initialization method in which the browser and URL values are getting fetched from Property file

	public static void initialization() {

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", userDir+"\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
			
			

		}
		if (prop.getProperty("browser").equalsIgnoreCase("safari") || osName.contains("Mac")){

			
			driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));

		}
		
		
		

	}
	//Below is the code for taking screenshot

	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(userDir+ "\\screenshots\\" +result+"screenshot.png"));
		
	}
}
