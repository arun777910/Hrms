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

public class Base {
	
	
	protected Playwright playwright;
	protected Browser browser;
	protected BrowserContext context;
	protected Page page;
	
	@BeforeMethod	
	public void setUp() {
	
	playwright = Playwright.create();

	browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	
	context = browser.newContext();
	
	page = context.newPage();
	
	}

	@AfterMethod	
	public void tearDown() {

	context.close();
	
	browser.close();

	playwright.close();
	
	}

}
