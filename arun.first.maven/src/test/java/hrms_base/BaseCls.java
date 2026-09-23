package hrms_base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseCls {
	
	
	protected Playwright playwright;
	protected Browser browser;
	protected BrowserContext context;
	protected Page page;
	
	@BeforeClass	
	public void setUp() 
	{
	playwright = Playwright.create();

	browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	
	context = browser.newContext();
	
	page = context.newPage();
	
	}

	@AfterClass	
	public void tearDown() {

	context.close();
	
	browser.close();

	playwright.close();
	
	}

}
