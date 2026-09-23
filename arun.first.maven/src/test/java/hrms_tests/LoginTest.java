package hrms_tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import hrms_base.Base;
import hrms_pages.LoginPage;

public class LoginTest extends Base 
{
	LoginPage loginPage;
	
	

	// NEGATIVE TEST	
	
	@Test(priority = 1)

	public void invalidLoginTest() {

	loginPage = new LoginPage(page);
	loginPage.openLoginPage();
	loginPage.login("invalid@test.com","WrongPassword@123");
	page.waitForTimeout(2000);
	// Copy error message
	String errorMessage = loginPage.getErrorMessage();
	System.out.println("Error Message: " + errorMessage);
	assertEquals("Invalid email or password",errorMessage);
	loginPage.clickOkButton();
	page.waitForTimeout(3000);
	System.out.println("URL after invalid login: "+ loginPage.getCurrentUrl());

	//assertTrue(loginPage.getCurrentUrl().contains("/login"),"Invalid user should not login");
	
	}
	
// WRONG PASSWORD(priority = 2)
	@Test
	
	public void wrongPasswordTest() {

    loginPage = new LoginPage(page);
	loginPage.openLoginPage();
	loginPage.login("arunsakkaravarthy777@gmail.com","WrongPassword@123");
	page.waitForTimeout(2000);
	// Copy error message
		String errorMessage = loginPage.getErrorMessage();
		System.out.println("Error Message: " + errorMessage);
		assertEquals("Invalid email or password",errorMessage);
		loginPage.clickOkButton();
		page.waitForTimeout(3000);
		System.out.println("URL after invalid login: "+ loginPage.getCurrentUrl());
	    page.waitForTimeout(3000);
	//assertTrue(loginPage.getCurrentUrl().contains("/login"),"Wrong password should not allow login");
	
	}
// EMPTY LOGIN
	
	@Test(priority = 3)
	
	public void emptyLoginTest() {

	loginPage = new LoginPage(page);
	loginPage.openLoginPage();
	loginPage.clickLogin();
	page.waitForTimeout(2000);
	// Get error messages
	
	String eamilreqError = loginPage.getemailRequiredError();
	String passwordreqerror=loginPage.getpasswordRequiredError();
	
	// Print messages
	
	System.out.println("Email Error: " + eamilreqError);
	
	System.out.println("Password Error: " + passwordreqerror);

	// Validate messages
	
	assertEquals("Email is required",eamilreqError);
	
	assertEquals("Password is required", passwordreqerror);
	page.waitForTimeout(3000);
	
	//assertTrue(	loginPage.getCurrentUrl().contains("/login"),"Empty login should not be accepted");

	}
	
	// POSITIVE TEST	
		@Test(priority = 4)
		
		public void validLoginTest() 
		{

		loginPage = new LoginPage(page);
		loginPage.openLoginPage();
		loginPage.login("arunsakkaravarthy777@gmail.com","Arun@777");
		
		page.waitForTimeout(3000);

		System.out.println(	"URL after login: " + loginPage.getCurrentUrl());
		loginPage.clickLogout();

		//assertTrue(!loginPage.getCurrentUrl().contains("/login"),"Login failed");
		
		}
}
