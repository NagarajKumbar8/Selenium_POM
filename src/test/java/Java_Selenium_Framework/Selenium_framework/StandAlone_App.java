package Java_Selenium_Framework.Selenium_framework;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Java_Selenium_Framework.Selenium_framework.pageobjects.Cart_page;
import Java_Selenium_Framework.Selenium_framework.pageobjects.Login_page;
import Java_Selenium_Framework.Selenium_framework.pageobjects.Product_catalogue;

public class StandAlone_App {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		// WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		Login_page login_page=new Login_page(driver);
		login_page.openurl();
		login_page.loginscreen("nagarajkumbar2225@gmail.com", "@Nagu123");
		
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * 
		 * List<WebElement> products =
		 * driver.findElements(By.xpath("//h5[@style=\"text-transform: uppercase;\"]"));
		 */
		
		Product_catalogue product_catalogue = new Product_catalogue(driver);
		List<WebElement> products=product_catalogue.getProductsList();
		product_catalogue.addToCart(productName);
		product_catalogue.gototcart();
		Cart_page Cart_page=new Cart_page(driver);
		
		Boolean match= Cart_page.verifyproductpresent(productName);
		
		
		
	

		/*
		 * // adding input by using actions Actions a = new Actions(driver);
		 * a.sendKeys(driver.findElement(By.
		 * xpath("//input[@placeholder=\"Select Country\"]")),
		 * "India").build().perform();
		 * 
		 * wait.until(ExpectedConditions .visibilityOfElementLocated(By.
		 * xpath("//button[@class=\"ta-item list-group-item ng-star-inserted\"]")));
		 * 
		 * driver.findElement(By.xpath("//span[text()=\" India\"]")).click();
		 * 
		 * JavascriptExecutor js2 = (JavascriptExecutor) driver;
		 * 
		 * //js2.executeScript("window.scrollBy(0, 580)");
		 * js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 * 
		 * Thread.sleep(3000); WebElement Placeorder = driver.findElement(By.
		 * xpath("//div[@class=\"actions\"]/a[text()=\"Place Order \"]"));
		 * 
		 * //js2.executeScript("arguments[0].scrollIntoView();", Placeorder);
		 * wait.until(ExpectedConditions.elementToBeClickable(Placeorder));
		 * Placeorder.click();
		 * 
		 * String confirm =
		 * driver.findElement(By.xpath("//h1[@class=\"hero-primary\"]")).getText();
		 * 
		 * Assert.assertEquals(confirm, confirm);
		 */		driver.quit();

	}

	/*
	 * @Test public void test1() throws InterruptedException { String productName =
	 * "ZARA COAT 3"; // WebDriverManager.chromedriver().setup();
	 * 
	 * WebDriver driver = new ChromeDriver();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	 * 
	 * driver.get("https://rahulshettyacademy.com/client");
	 * driver.manage().window().maximize();
	 * 
	 * driver.findElement(By.id("userEmail")).sendKeys("nagarajkumbar2225@gmail.com"
	 * ); driver.findElement(By.id("userPassword")).sendKeys("@Nagu123");
	 * driver.findElement(By.id("login")).click();
	 * 
	 * List<WebElement> products =
	 * driver.findElements(By.xpath("//h5[@style=\"text-transform: uppercase;\"]"));
	 * 
	 * WebElement prod = products.stream() .filter(product ->
	 * product.findElement(By.tagName("b")).getText().equalsIgnoreCase("ZARA COAT 3"
	 * )) .findFirst().orElse(null);
	 * 
	 * prod.findElement(By.xpath("//button[@class=\"btn w-10 rounded\"]")).click();
	 * 
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
	 * "toast-container")));
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(
	 * ".ng-animating")));
	 * 
	 * driver.findElement(By.xpath("(//button[@class=\"btn btn-custom\"]/i)[3]")).
	 * click();
	 * 
	 * List<WebElement> Cardproducts =
	 * driver.findElements(By.xpath("//div[@class=\"cartSection\"]/h3")); // check
	 * match product name using anyMatch method boolean match =
	 * Cardproducts.stream() .anyMatch(Cartproduct ->
	 * Cartproduct.getText().equalsIgnoreCase(productName));
	 * Assert.assertTrue(match); // scroll littel bit to click checkout
	 * 
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
	 * xpath("//h1[text()=\"My Cart\"]"))); JavascriptExecutor js =
	 * (JavascriptExecutor) driver;
	 * js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	 * 
	 * Thread.sleep(3000); WebElement Checkout =
	 * driver.findElement(By.xpath("//button[@type=\"button\"][text()=\"Checkout\"]"
	 * ));
	 * 
	 * //js.executeScript("arguments[0].scrollIntoView(true);", Checkout);
	 * 
	 * //wait.until(ExpectedConditions.elementToBeClickable(Checkout));
	 * Checkout.click();
	 * 
	 * // adding input by using actions Actions a = new Actions(driver);
	 * a.sendKeys(driver.findElement(By.
	 * xpath("//input[@placeholder=\"Select Country\"]")),
	 * "India").build().perform();
	 * 
	 * wait.until(ExpectedConditions .visibilityOfElementLocated(By.
	 * xpath("//button[@class=\"ta-item list-group-item ng-star-inserted\"]")));
	 * 
	 * driver.findElement(By.xpath("//span[text()=\" India\"]")).click();
	 * 
	 * JavascriptExecutor js2 = (JavascriptExecutor) driver;
	 * 
	 * //js2.executeScript("window.scrollBy(0, 580)");
	 * js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	 * 
	 * Thread.sleep(3000); WebElement Placeorder = driver.findElement(By.
	 * xpath("//div[@class=\"actions\"]/a[text()=\"Place Order \"]"));
	 * 
	 * //js2.executeScript("arguments[0].scrollIntoView();", Placeorder);
	 * wait.until(ExpectedConditions.elementToBeClickable(Placeorder));
	 * Placeorder.click();
	 * 
	 * String confirm =
	 * driver.findElement(By.xpath("//h1[@class=\"hero-primary\"]")).getText();
	 * 
	 * Assert.assertEquals(confirm, confirm); driver.quit();
	 * 
	 * 
	 * }
	 */
}
