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
public class CreateNewUser extends Add_Item_To_Cart {

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

		WebElement CreateAccount = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CreateAccount"))));
		CreateAccount.click();

		WebElement FirstName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("FirstName"))));
		FirstName.sendKeys("Test");

		WebElement LastName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("LastName"))));
		LastName.sendKeys("Test");

		WebElement Email = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Email"))));
		Email.sendKeys("Test129@test.com");

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

			System.out.println("Alert Message > " + AlertMessage);
		} catch (Exception e) {
			System.out.println("New Email Address");
		}

		try {
			String RewardId = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("RewardId"))))
					.getText();
			System.out.println("New Reward ID Created > " + RewardId);
		} catch (Exception e) {
			// System.out.println("New Reward ID Created");

		}

		driver.close();

	}

}
