package BigLotAutomation.TestOrder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class BaseCalss {
	public static WebDriver driver;

	public static void startChrome() throws IOException {
		Properties prop = new Properties();
		File f = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\WebObjects\\BigLotApplication.Properties");
		FileReader browser = new FileReader(f);
		prop.load(browser);

		if (prop.getProperty("Browser").equals("chrome")) {
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("ff")) {

			driver = new FirefoxDriver();
		}

	}

	public static void getURL() throws IOException {

		Properties prop = new Properties();
		File f = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\WebObjects\\BigLotApplication.Properties");
		FileReader browser = new FileReader(f);
		prop.load(browser);

		if (prop.getProperty("url").equals("qa")) {
			driver.get("https://infosysqa:infosysbl@qa-store.biglots.com/");
		} else if (prop.getProperty("url").equals("prod")) {

			driver.get("https://www.biglots.com/");
		}

	}
	
	public static void provideCutomerData(String filepath,String filename,String sheetname) throws IOException{
		
		//Object for file path and filename
		
		File file =new File(filepath+"\\"+filename);
		
		//Object for Read file
		
		@SuppressWarnings("resource")
		FileInputStream  inputStream = new FileInputStream(file);
		
		
		//Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = filename.substring(filename.indexOf("."));
		
		
		
		
		
		
		
	}
	
	

}
