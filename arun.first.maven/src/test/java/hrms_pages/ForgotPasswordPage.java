package hrms_pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;

public class ForgotPasswordPage 
{
	private Page page;
    private Locator ForgotPasswordButton;
    private Locator Email;
    private Locator clicksendresetlink;
	public ForgotPasswordPage(Page page) 
	{
	
	this.page = page;
	
	ForgotPasswordButton =page.getByText("Forgot Password?",new Page.GetByTextOptions().setExact(true));
	Email = page.getByPlaceholder("Enter Your Email");
	clicksendresetlink= page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Send Reset Link"));
	}
	
	public void clickForgotPassword() 
	{
		ForgotPasswordButton.click();
		
		}

	public void verifyForgotPasswordPageOpened()
	{
		
	System.out.println("Forgot Password URL: " + page.url());
	}

	public void enterEmail(String email)
	{

		Email.fill("arunsakkaravarthy777@gmail.com");
	
	}

	public void verifyEmailFieldVisible() 
	{

	assertThat(page.getByPlaceholder("Enter Your Email")).isVisible();	
}


	public void clickSendResetLink() 
	{
		clicksendresetlink.click();
		
	}
	
}
