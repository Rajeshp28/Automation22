package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaLoginPage {
	@FindBy(xpath="//input[@id='userid']") private WebElement userId;
	@FindBy(xpath="//input[@id='password']") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement login;
	@FindBy(xpath="//a[@class='text-light forgot-link']") private WebElement forgotPassword;
	@FindBy(xpath="(//span[@class='su-message'])[1]") private WebElement errorText;
	

	public ZerodhaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserID (String userName){
		userId.sendKeys(userName);
	}
	
	public void enterPassword(String pass){
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
	public void clickonForgotPassword() {
		forgotPassword.click();
	}
	
	public String getErrorText() {
		String s=errorText.getText();
		return s;
		
		//System.out.println(s);
	}
}
