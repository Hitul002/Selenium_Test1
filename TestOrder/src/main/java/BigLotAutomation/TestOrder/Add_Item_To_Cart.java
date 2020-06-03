package BigLotAutomation.TestOrder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class Add_Item_To_Cart extends BaseCalss {
	static Properties prop;
	static EventFiringWebDriver eventfire;

	//@Test

	public static void addItemtoCart() throws Exception {

		startChrome();
		getURL();
		// InputStream
		prop = new Properties();
		File f = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\WebObjects\\BigLotApplication.Properties");
		FileReader reader = new FileReader(f);
		prop.load(reader);

		driver.manage().window().fullscreen();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement CloseWelCome = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CloseSiteLaunchModal"))));
		CloseWelCome.click();

		WebElement SearchProduct = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ShopDepartment"))));
		SearchProduct.click();

		WebElement SelectProduct = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("HomeDecor"))));
		takeSnapShot(driver, "HomeDecor");
		SelectProduct.click();

		WebElement Candel = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Candel"))));
		takeSnapShot(driver, "Candel");
		Candel.click();

		driver.manage().window().fullscreen();

		WebElement FulfillmentSlider = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("FulfillmentSlider"))));
		FulfillmentSlider.click();

		WebElement SelectImage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SelectImage"))));
		SelectImage.click();

		/*
		 * WebElement SelectImage1 = wait
		 * .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.
		 * getProperty("SelectImage")))); SelectImage1.click();
		 */

		WebElement SelectStore = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SelectStore"))));
		takeSnapShot(driver, "SelectStore");
		SelectStore.click();

		WebElement InstockCheckbox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("InstockCheckbox"))));
		InstockCheckbox.click();

		WebElement AddToWestervilleStore = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AddToWestervilleStore"))));
		driver.manage().window().fullscreen();
		takeSnapShot(driver, "AddToWestervilleStore");
		AddToWestervilleStore.click();

		WebElement ViewCart = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ViewCart"))));
		ViewCart.click();
		driver.manage().window().fullscreen();
		takeSnapShot(driver, "ViewCart");

		String ItemNumer = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ItemNumer"))))
				.getText();
		System.out.println("ItemNumer:" + ItemNumer);

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

		String EstimatedOrderTotal = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("EstimatedOrderTotal"))))
				.getText();
		System.out.println("EstimatedOrderTotal:" + EstimatedOrderTotal);

		WebElement Promo = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Promo"))));
		Promo.click();
		Promo.sendKeys(Keys.PAGE_DOWN);
		driver.manage().window().fullscreen();
		takeSnapShot(driver, "ViewCartFull");

		List<WebElement> elements = driver.findElements(By.xpath("id"));

		System.out.println("Number of elements:" + elements.size());

		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Name text:" + elements.get(i).getAttribute("value"));
		}

		WebElement Checkout = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Checkout"))));
		Checkout.click();
		
		
		 driver.close();

	}

}
