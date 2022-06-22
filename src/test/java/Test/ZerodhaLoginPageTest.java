package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POJO.Browser;
import POM.ZerodhaLoginPage;
import Utility.Parametrization;

public class ZerodhaLoginPageTest {
	WebDriver driver;
	
	@BeforeMethod
	public void browser() {
		driver=Browser.OpenBrowser();
	}
	
	@Test
	public void LoginToZerohaWithValidCredentials() throws EncryptedDocumentException, IOException {

		ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
		String userName=Parametrization.getData(0, 1);
		String password=Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserID(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
	}
	@Test
	public void ClickOnLoginWithoutDataTest() throws EncryptedDocumentException, IOException {
		ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnLogin();
		
		String Text=zerodhaLoginPage.getErrorText();
		
		String expectedText="User ID should be minimum 6 characters.";
		
		//Assert.assertEquals(Text, expectedText);// hard assert
		
		SoftAssert softAssert=new SoftAssert();//soft assert
		softAssert.assertEquals(Text, expectedText);//soft assert
		
		String userName=Parametrization.getData(0, 1);
		String password=Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserID(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		
		softAssert.assertAll();
	}

}
