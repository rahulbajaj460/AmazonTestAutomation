package pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;

public class LoginPage extends BasePage{

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@type='email']")
	WebElement signInEmail;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement signInPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement continueButtonPassword;
	
	@FindBy(xpath="//span[text()='Account & Lists']/preceding-sibling::div/span")
	WebElement userName;
	
	
	public void signInDetails() throws IOException, InterruptedException
	{
		BaseClass baseClassPage = new BaseClass();
		String email = baseClassPage.getEmail();
		System.out.println(email);
		signInEmail.sendKeys(email);
		
		continueButton.click();
		Thread.sleep(2000);
		
		String password = baseClassPage.getPassword();
		System.out.println(password);
		signInPassword.sendKeys(password);
		
		System.out.println("Stage 1");
		
		continueButtonPassword.click();
		
		Thread.sleep(5000);
		System.out.println("Reached here.");
		
	}
	
	public String retrieveUsername() 
	{
		String username = userName.getText();
		return username;
	}

}
