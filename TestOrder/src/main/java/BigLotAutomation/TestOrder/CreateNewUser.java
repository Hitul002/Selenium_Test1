package BigLotAutomation.TestOrder;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Strings;

import excelutils.ExcelUtil;

@SuppressWarnings("unused")
public class CreateNewUser extends Add_Item_To_Cart {
	static ExcelUtil data;

	@DataProvider
	public static Object[] getfromexcel() {
		Object[] data = new Object[12];

		data[0] = "test2691@test.com";
		data[1] = "test271@test.com";
		data[2] = "test181@test.com";
		data[3] = "test191@test.com";
		data[4] = "test201@test.com";
		data[5] = "test211@test.com";
		data[6] = "test221@test.com";
		data[7] = "test231@test.com";
		data[8] = "test241@test.com";
		data[9] = "test251@test.com";
		data[10] = "test2169@test.com";
		data[11] = "test217@test.com";

		return data;

	}

	@Test(dataProvider = "getfromexcel")
	public static void loop(String email) throws Exception {
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

		WebElement CreateAccount = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CreateAccount"))));
		CreateAccount.click();

		WebElement FirstName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("FirstName"))));
		FirstName.sendKeys("Test");

		WebElement LastName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("LastName"))));
		LastName.sendKeys("Test");

		// email
		WebElement Email = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Email"))));
		Email.sendKeys(email);

		WebElement ZipCode = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ZipCode"))));
		ZipCode.sendKeys("43081");

		WebElement Password = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Password"))));
		Password.sendKeys("Password1");

		WebElement ConfirmPassword = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ConfirmPassword"))));
		ConfirmPassword.sendKeys("Password1");

		WebElement CreatAccount = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CreatAccount"))));
		CreatAccount.click();

		try {
			String AlertMessage = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AlertMessage"))))
					.getText();

			System.out.println("There is already an account using this email  > " + AlertMessage);
			takeSnapShot(driver, "Screen1");

		} catch (Exception e) {

			System.out.println("Used Email Address");
			takeSnapShot(driver, "Screen2");

		}

		try {
			String RewardId = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("RewardId"))))
					.getText();
			System.out.println("New Reward ID Created > " + RewardId);
		} catch (Exception e) {

		}

		driver.close();

	}

}
