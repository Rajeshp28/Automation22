package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.ZerodhaLoginPage;
import POM.ZerodhaPinPage;
import Utility.Parametrization;

public class ZerodhaPinPageTest {
WebDriver driver;
	
	@BeforeMethod
	public void browser() {
		driver=Browser.OpenBrowser();
	}
	@Test
	public void LoginToZerohaWithValidCredentials() throws EncryptedDocumentException, IOException, InterruptedException {

		ZerodhaLoginPage zerodhaHomePage=new ZerodhaLoginPage(driver);
		String userName=Parametrization.getData(0, 1);
		String password=Parametrization.getData(1, 1);
		zerodhaHomePage.enterUserID(userName);
		zerodhaHomePage.enterPassword(password);
		zerodhaHomePage.clickOnLogin();
		
		Thread.sleep(5000);
		ZerodhaPinPage zerodhaPinPage=new ZerodhaPinPage(driver);
		String pin= Parametrization.getData(2, 1);
		System.out.println(pin);
		zerodhaPinPage.enterPin(pin);
		zerodhaPinPage.clickOnConinue();
	}
}
