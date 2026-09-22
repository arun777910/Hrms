package hrms_tests;

import org.testng.annotations.Test;

import hrms_base.Base;
import hrms_pages.ForgotPasswordPage;
import hrms_pages.Loginpage;

public class ForgotPasswordTest extends Base
{
	Loginpage loginpage;
	ForgotPasswordPage forgotpasswordpage;
	
	@Test
	
	public void verifyForgotPasswordPage()
	
	{
	
	// Step 1: Open login page
	loginpage = new Loginpage(page);
	loginpage.openLoginPage();


	// Step 3: Create Forgot Password page object
	
	ForgotPasswordPage forgotpasswordpage =new ForgotPasswordPage(page);
	
	// Click Forgot Password
		
	forgotpasswordpage.clickForgotPassword();
	
	// Step 4: Print URL
	
	forgotpasswordpage.verifyForgotPasswordPageOpened();

	// Step 5: Verify email field
	
	forgotpasswordpage.verifyEmailFieldVisible();
	page.waitForTimeout(2000);
	
	forgotpasswordpage.enterEmail("arunsakkaravarthy777@gmail.com");
	page.waitForTimeout(2000);
	forgotpasswordpage.clickSendResetLink();
	
	}

	}

