package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaDashboardPage {
	
	@FindBy(xpath="//input[@type='text']") private WebElement search;
	@FindBy(xpath="(//span[@class='nice-name'])[1]") private WebElement tatamotors;
	@FindBy(xpath="(//button[@type='button'])[1]") private WebElement buyB;
	@FindBy(xpath="//button[@class='button-orange sell']") private WebElement sellS;
	@FindBy(xpath="//span[@class='icon icon-trending-up']") private WebElement chartC;
	@FindBy(xpath="//span[@class='icon icon-ellipsis']") private WebElement more;
	@FindBy(xpath="(//label[@class='su-radio-label'])[1]") private WebElement bse;
	@FindBy(xpath="(//label[@class='su-radio-label'])[2]") private WebElement nse;
	@FindBy(xpath="(//label[@class='su-radio-label'])[9]") private WebElement market;
	@FindBy(xpath="(//label[@class='su-radio-label'])[10]") private WebElement limit;
	@FindBy(xpath="//button[@class='submit']") private WebElement buy;
	@FindBy(xpath="//li[@data-balloon='Watchlist 2']") private WebElement watchlist2;
	@FindBy(xpath="//li[@class='search-result-item']") private WebElement tataMotors;
	@FindBy(xpath="//button[@class='button-green']") private WebElement add;
	@FindBy(xpath="//span[@class='nice-name']") private List<WebElement> addedStock;
	
	public ZerodhaDashboardPage(WebDriver driver) {
	PageFactory.initElements(driver, this);

	}
	
	public void enterToSearchbar(String nameOfStock) {
		search.sendKeys(nameOfStock);
	}
	
	public void clickOnBuyB(WebDriver driver) throws InterruptedException {	
		Actions a=new Actions(driver);
		Thread.sleep(2000);
		a.moveToElement(tatamotors);
		a.perform();
		a.moveToElement(buyB);
		//a.perform();
		a.click();
		a.perform();	
	}
	
	public void clickOnBSE() {
		bse.click();
	}
	
	public void clickOnMarket() {
		market.click();
	}
	
	public void clickOnBuy() {
		buy.click();
	}
	public void clickOnWatchlist2() {
		watchlist2.click();
	}
	public void addStockInWatchlist(WebDriver driver) throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(tataMotors);
		act.perform();
		Thread.sleep(3000);
		act.moveToElement(add);
		act.perform();
		add.click();
	}
	
	public void checkWatchlist(WebDriver driver) {
	for(int i=0; i<addedStock.size(); i++) {
		WebElement a= addedStock.get(i);
		System.out.println(a);
		String b=a.getText();
		if(b.equalsIgnoreCase("TATAMOTORS")) {
			System.out.println("Stock is added succefully");
			break;
			
		}
		
	}
	}
	
	
	
}