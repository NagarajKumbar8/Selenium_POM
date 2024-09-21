package Java_Selenium_Framework.Selenium_framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.Abstract_components;

public class Cart_page extends Abstract_components{
	
	@FindBy(xpath="//div[@class=\"cartSection\"]/h3") List<WebElement> Cartproducts;
	
	
	WebDriver driver;
	// constructor
	public Cart_page(WebDriver driver) 
	{
		//initialization driver
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}
	

public boolean verifyproductpresent(String productName)
{
	boolean match = Cartproducts.stream()
			.anyMatch(Cartproduct -> Cartproduct.getText().equalsIgnoreCase(productName));
	Assert.assertTrue(match);
	return match;
}
	

public void gotocheckoutpage() throws InterruptedException
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
	Thread.sleep(3000);
	WebElement Checkout = driver.findElement(By.xpath("//button[@type=\"button\"][text()=\"Checkout\"]"));
	
	//js.executeScript("arguments[0].scrollIntoView(true);", Checkout);

	//wait.until(ExpectedConditions.elementToBeClickable(Checkout));
	Checkout.click();
}
	

	
	
	

}
