package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;


public class TC_001_AccountLoginTest extends BaseClass{

	
	@Test
	public void verifyAccountLogin() {
		
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickOnAccount_Lists();
			
			LoginPage lp = new LoginPage(driver);
			lp.signInDetails();
			String username = lp.retrieveUsername();
			String updatedUsername=username.replaceFirst("Hello, ","");
			System.out.println(updatedUsername);
			Assert.assertEquals(updatedUsername, "Test");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
