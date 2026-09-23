package hrms_pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage 
{
	private Page page;

	// Locators
	
	private Locator email;
	private Locator password;
	private Locator loginButton;
	private Locator errorMessage;
	private Locator emailRequiredError;
	private Locator passwordRequiredError;
	private Locator okButton;
	private Locator logoutButton;
	
	// Constructor
	
	public LoginPage (Page page)
	{

	this.page = page;

	email = page.locator("//input[@name='email']");
	
	password = page.locator("//input[@name='password']");

	loginButton = page.getByText("Login");
	errorMessage = page.getByText("Invalid email or password");
	okButton = page.getByText("OK");
	emailRequiredError = page.getByText("Email is required");
	passwordRequiredError = page.getByText("Password is required");
	logoutButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Logout"));
			
	}
	// Open Login Page
	
	public void openLoginPage() {
	
	page.navigate("https://dev-hrms.aahaas.com/login");
	
	}
	// Enter Email

	public void enterEmail(String emailAddress) 
	{

	email.fill("arunsakkaravarthy777@gmail.com");
	
	}

	// Enter Password
	
	public void enterPassword(String passwordValue) {
	
	password.fill("Arun@777");
	
	}
	
	// Click Login Button
	
	public void clickLogin() 
	{
	loginButton.click();
	}
	
	// Get/copy error message
	
	public String getErrorMessage() 
	{
	return errorMessage.textContent();
	}

	// Click OK button
	
	public void clickOkButton() 
	{
	okButton.click();
	}
	
	// Validation error locators
	
	public String getemailRequiredError()
	{
		return emailRequiredError.textContent();
		}
	
	public String getpasswordRequiredError()
	{
		return passwordRequiredError.textContent();
		}
	
	// Click Logout button
	public void clickLogout() 
	{
	logoutButton.click();
	}
	// Complete Login
	
	public void login(String emailAddress, String passwordValue) 
	{

  email.fill(emailAddress);
	
	password.fill(passwordValue);
	
	loginButton.click();
	
	}
	
	// Get Current URL
	
	public String getCurrentUrl() {

	return page.url();
	
	}
	
}
	/*
	public static void main(String[] args) 
	{
		Playwright playwright=Playwright.create();
		//Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		 Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
		
				Page page = browser.newPage();
			
				page.navigate("https://dev-hrms.aahaas.com/login");
				
				System.out.println(page.title());
				
				
				page.locator("//input[@name='email']").fill("arunsakkaravarthy777@gmail.com");
				
				page.locator("//input[@name='password']").fill("Arun@777");
				
				//page.locator("//button[text()='Login']").click();
				
				page.getByText("Login").click();
				page.waitForTimeout(3000);
				
				System.out.println(page.url());

			//	browser.close(); 
				}
		

	}*/


 
