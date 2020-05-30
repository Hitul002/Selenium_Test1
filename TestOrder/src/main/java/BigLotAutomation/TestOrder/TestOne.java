package BigLotAutomation.TestOrder;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Strings;

@SuppressWarnings("unused")
public class TestOne extends Add_Item_To_Cart {

	@Test
	public static void loop() throws FileNotFoundException, IOException, InterruptedException {
		startChrome();
		getURL();
		Properties prop = new Properties();
		File f = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\WebObjects\\BigLotApplication.Properties");
		FileReader reader = new FileReader(f);
		prop.load(reader);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement CloseWelCome = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CloseSiteLaunchModal"))));
		CloseWelCome.click();

		WebElement SignUpDopDown = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SignUpDopDown"))));
		SignUpDopDown.click();

		WebElement SelectMyAccountFromDown = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SelectMyAccountFromDown"))));
		SelectMyAccountFromDown.click();
		
		WebElement CreateAccount = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CreateAccount"))));
		CreateAccount.click();

	}

}
