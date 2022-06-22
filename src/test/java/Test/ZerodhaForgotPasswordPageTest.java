package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.ZerodhaForgotPasswordPage;
import POM.ZerodhaLoginPage;
import Utility.Parametrization;

public class ZerodhaForgotPasswordPageTest {
	WebDriver driver;
	@BeforeMethod
	public void browser() {
		driver=Browser.OpenBrowser();
	}
	@Test
	public void ResetAccountWithUserId() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaHomePage=new ZerodhaLoginPage(driver);
		zerodhaHomePage.clickonForgotPassword();
		ZerodhaForgotPasswordPage zerodhaForgotPasswordPage= new ZerodhaForgotPasswordPage(driver);
		String user= Parametrization.getData(0, 1);
		String pan= Parametrization.getData(3, 1);
		String email=Parametrization.getData(4, 1);	
		zerodhaForgotPasswordPage.enterUserId(user);
		zerodhaForgotPasswordPage.enterPan(pan);
		zerodhaForgotPasswordPage.enterEmail(email);
		Thread.sleep(3000);
		zerodhaForgotPasswordPage.clickOnReset();
	}
	@Test
	public void ResetAccountWithForgotMyUserId() throws EncryptedDocumentException, IOException {
		ZerodhaLoginPage zerodhaHomePage= new ZerodhaLoginPage(driver);
		zerodhaHomePage.clickonForgotPassword();
		
		ZerodhaForgotPasswordPage zerodhaForgotPasswordPage= new ZerodhaForgotPasswordPage(driver);
		zerodhaForgotPasswordPage.clickOnForgotUserId(driver);
		String pan=Parametrization.getData(3, 1);
		String email= Parametrization.getData(4, 1);
		zerodhaForgotPasswordPage.enterPan(pan);
		zerodhaForgotPasswordPage.enterEmail(email);
		zerodhaForgotPasswordPage.clickOnReset();
		
	}
}
