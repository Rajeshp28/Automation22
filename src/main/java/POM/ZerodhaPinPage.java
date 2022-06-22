package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaPinPage {
	@FindBy(xpath="//input[@type='password']") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement submit;
	
	public ZerodhaPinPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterPin(String pass) {
		password.sendKeys(pass);	
	}
	
	public void clickOnConinue() {
		submit.click();
	}
	
}
