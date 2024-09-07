package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_SearchFunctionalityTest extends BaseClass{
	
	@Test
	public void validateSearchFunctionality() {
		
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickOnSearchIcon();
			hp.validateSearchSuggestionsList();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
