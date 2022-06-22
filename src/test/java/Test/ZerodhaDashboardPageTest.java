package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.ZerodhaDashboardPage;
import POM.ZerodhaLoginPage;
import POM.ZerodhaPinPage;
import Utility.Parametrization;

public class ZerodhaDashboardPageTest {
	WebDriver driver;
	@BeforeMethod
	public void browser() {
		driver=Browser.OpenBrowser();
	}
	@Test
	public void placeMarketOrder() throws EncryptedDocumentException, IOException, InterruptedException {
			
		ZerodhaDashboardPage zerodhaDashboardPage=new ZerodhaDashboardPage(driver);
		
		ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
		String userName=Parametrization.getData(0, 1);
		String password=Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserID(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		
		Thread.sleep(5000);
		ZerodhaPinPage zerodhaPinPage=new ZerodhaPinPage(driver);
		String pin= Parametrization.getData(2, 1);
		System.out.println(pin);
		zerodhaPinPage.enterPin(pin);
		zerodhaPinPage.clickOnConinue();
			
		zerodhaDashboardPage.enterToSearchbar("tatamotors");
		
		zerodhaDashboardPage.clickOnBuyB(driver);

		//zerodhaDashboardPage.clickOnBSE();
		//Thread.sleep(4000);

		zerodhaDashboardPage.clickOnMarket();

		zerodhaDashboardPage.clickOnBuy();
				
	}
	@Test
	public void addStockInWatchlist() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
		String userName=Parametrization.getData(0, 1);
		String password=Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserID(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(2000);
		
		ZerodhaPinPage zerodhaPinPage=new ZerodhaPinPage(driver);
		String pin= Parametrization.getData(2, 1);
		zerodhaPinPage.enterPin(pin);
		zerodhaPinPage.clickOnConinue();
		Thread.sleep(5000);
		
		ZerodhaDashboardPage zerodhaDashboardPage=new ZerodhaDashboardPage(driver);
		zerodhaDashboardPage.clickOnWatchlist2();
		Thread.sleep(3000);
		zerodhaDashboardPage.enterToSearchbar("TATAMOTORS");
		Thread.sleep(4000);
		zerodhaDashboardPage.addStockInWatchlist(driver);

	}
	
	@Test
	public void checkWatchlist() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
		String userName=Parametrization.getData(0, 1);
		String password=Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserID(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(2000);
		
		ZerodhaPinPage zerodhaPinPage=new ZerodhaPinPage(driver);
		String pin= Parametrization.getData(2, 1);
		zerodhaPinPage.enterPin(pin);
		zerodhaPinPage.clickOnConinue();
		Thread.sleep(5000);
		
		ZerodhaDashboardPage zerodhaDashboardPage= new ZerodhaDashboardPage(driver);
		zerodhaDashboardPage.clickOnWatchlist2();
		Thread.sleep(2000);
		zerodhaDashboardPage.checkWatchlist(driver);
				
	
}
}

