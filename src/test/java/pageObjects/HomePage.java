package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testBase.BaseClass;

public class HomePage extends BasePage{

	WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//span[text()='Account & Lists']//parent::a") 
	WebElement accountLists;
	
	@FindBy(xpath="//input[@placeholder='Search Amazon.in']")
	WebElement searchProductPlace;
	
	@FindBy(xpath="//div[@class='autocomplete-results-container']/div/div[@class='left-pane-results-container']/div/div/div[contains(@class,'suggestion') and not(contains(@class,'search'))]")
	List<WebElement> searchSuggestionsList;
	
	public void clickOnAccount_Lists()
	{
		accountLists.click();	
	}
	
	
	public void clickOnSearchIcon() throws IOException, InterruptedException
	{
		BaseClass baseClassPage = new BaseClass();
		String searchProduct = baseClassPage.getSearchProduct();
		Thread.sleep(1000);
		searchProductPlace.sendKeys(searchProduct);
		
	}
	
	public void validateSearchSuggestionsList() throws IOException, InterruptedException
	{
		BaseClass baseClassPage = new BaseClass();
		String searchProduct = baseClassPage.getSearchProduct();
	
		Thread.sleep(2000);
		
		for(WebElement searchSuggestionElement : searchSuggestionsList) {
			String suggestionValue = searchSuggestionElement.getAttribute("aria-label");
			System.out.println(suggestionValue);
			Assert.assertTrue(suggestionValue.toLowerCase().contains(searchProduct.toLowerCase()));
			
		}
		
	}

}
