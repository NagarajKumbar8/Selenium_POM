package Java_Selenium_Framework.Selenium_framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Abstract_components;

public class Product_catalogue extends Abstract_components{
	
	WebDriver driver;
	// constructor
	public Product_catalogue(WebDriver driver) 
	{
		//initialization driver
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}
	
//List<WebElement> products = driver.findElements(By.xpath("//h5[@style=\"text-transform: uppercase;\"]"));
	
	@FindBy(xpath="//h5[@style=\"text-transform: uppercase;\"]") List<WebElement> products;
	@FindBy(css=(".ng-animating")) WebElement loader;
	
	By productsbuy =By.xpath("//h5[@style=\"text-transform: uppercase;\"]");
	
	By addToCart = By.xpath("//button[@class=\"btn btn-custom\"]/i)[3]");
	By Toastmsg= By.id("toast-container");
	
	
	
	public List<WebElement> getProductsList()
	{
		
		return products;
	}
	
	public WebElement getProductbyname(String ProductName)
	{
		WebElement prod = getProductsList().stream()
		.filter(product -> product.findElement(By.tagName("b")).getText().equalsIgnoreCase("ZARA COAT 3"))
		.findFirst().orElse(null);
		
		return prod;
	}
	
	public void addToCart(String ProductName)
	{
		WebElement prod= getProductbyname(ProductName);
		prod.findElement(addToCart).click();
		WaitForElementTOShow(Toastmsg);
		WaitforElementToDisapear(loader);
	}
	
	

	
	
	
}
