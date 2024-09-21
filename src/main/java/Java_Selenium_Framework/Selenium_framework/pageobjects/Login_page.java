package Java_Selenium_Framework.Selenium_framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Abstract_components;

public class Login_page extends Abstract_components{
	
	WebDriver driver;
	// constructor
	public Login_page(WebDriver driver) 
	{
		//initialization driver
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}
	

	//WebElement UserEmail= driver.findElement(By.id("userEmail"));
	//pagefactory format
	@FindBy(id="userEmail") WebElement userEmail;
	@FindBy(id="userPassword") WebElement userPassword;
	@FindBy(id="login") WebElement submit;
	
	public void openurl()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public void loginscreen(String Email, String Password)
	{
		userEmail.sendKeys(Email);
		userPassword.sendKeys(Password);
	}
	

}
