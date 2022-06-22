package POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaForgotPasswordPage {
	@FindBy(xpath="//input[@placeholder='User ID']") private WebElement userId;
	@FindBy(xpath="//input[@placeholder='PAN']") private WebElement pan;
	@FindBy(xpath="(//input[@type='text'])[2]") private WebElement email;
	@FindBy(xpath="//label[@for='radio-31']") private WebElement forgotUserId;
	@FindBy(xpath="//button[@class='button-orange wide']") private WebElement reset;
	@FindBy(xpath="//a[@class='text-xsmall text-light reset-account-button']") private WebElement backToLogin;
	
	public ZerodhaForgotPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}	
	public void enterUserId(String user) {
	userId.sendKeys(user);	
	}
	public void enterPan(String panNumber) {
		pan.sendKeys(panNumber);
	}
	public void enterEmail(String emailId) {
		email.sendKeys(emailId);
	}
	
	public void clickOnForgotUserId(WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("Script=arguments[0].click", forgotUserId);
		forgotUserId.click();
	}
	
	public void clickOnReset() {
		reset.click();
	}
	public void BackToLogin() {
		backToLogin.click();
	}
}
