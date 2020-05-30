package BigLotAutomation.TestOrder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class Add_Item_To_Cart extends BaseCalss {
	static Properties prop;

	public static void addItemtoCart() throws IOException, FileNotFoundException, InterruptedException {

		startChrome();
		getURL();
		// InputStream
		prop = new Properties();
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

		WebElement SearchProduct = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SearchBox"))));
		SearchProduct.sendKeys("810438075");

		WebElement SelectProduct = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SearchBox"))));
		SelectProduct.sendKeys(Keys.ENTER);

		WebElement ProductDisplay = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ProductDisplay"))));
		ProductDisplay.click();

		WebElement SelectStore = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SelectStore"))));
		SelectStore.click();

		WebElement InstockCheckbox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("InstockCheckbox"))));
		InstockCheckbox.click();

		WebElement AddToWestervilleStore = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AddToWestervilleStore"))));
		AddToWestervilleStore.click();

		WebElement ViewCart = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ViewCart"))));
		ViewCart.click();

		WebElement Promo = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Promo"))));
		Promo.click();

		String sub = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SubTotal"))))
				.getText();
		System.out.println("Sub Total:" + sub);

		String PickupInStore = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("PickUpInstoreType"))))
				.getText();
		System.out.println("PickupInStore:" + PickupInStore);

		String SaleTax = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SaleTax")))).getText();
		System.out.println("SaleTax:" + SaleTax);

		String ItemNumer = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ItemNumer"))))
				.getText();
		System.out.println("ItemNumer:" + ItemNumer);

		WebElement Checkout = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Checkout"))));
		Checkout.click();

		driver.close();

	}

}
