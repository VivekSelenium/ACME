package Acme.Acme;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class AceVendorSearch {
	@Test
	public static void aceVendor() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		WebElement email = driver.findElementById("email");
		email.sendKeys(Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		Thread.sleep(2000);
		WebElement Vendorbutton = driver.findElementByXPath("//button[text()[contains(.,'Vendors')]]");
		action.moveToElement(Vendorbutton).click().perform();
		Thread.sleep(2000);
		WebElement Search = driver.findElementByXPath("//a[contains(text(),'Search for Vendor')]");
		action.moveToElement(Search).click().perform();
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElementById("buttonSearch").click();
		String Country = driver.findElementByXPath("/html/body/div/div[2]/div/table/tbody/tr[2]/td[5]").getText();
		System.out.println("Country of the Vendor:" + Country);
		driver.findElementByXPath("//a[text()='Log Out']").click();
		driver.close();

	}
}
