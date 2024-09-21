package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstract_components {

	//Reusable stuffs or generic utilities 
	
	WebDriver driver;
	public Abstract_components(WebDriver driver)
	{
	
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath=("//button[@class=\"btn btn-custom\"]/i)[3]")) WebElement cartbtn;
	//driver.findElement(By.xpath("(//button[@class=\"btn btn-custom\"]/i)[3]")).click();
	@FindBy(xpath="//h1[text()=\"My Cart\"]") WebElement mycartlable; 
	//(By.xpath("//h1[text()=\"My Cart\"]")));

	public void WaitForElementTOShow(By findBy)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void WaitforElementToDisapear(WebElement element)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void gototcart()
	{
		cartbtn.click();
		
	}
	
}
