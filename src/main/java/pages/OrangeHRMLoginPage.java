package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;


public final class OrangeHRMLoginPage extends BasePage {
	
	/*NOTES
	 * 1. Assertions should be always created at the test page level and not page objects.
	 * 2. All of the page methods needs to have some return type for method chaining and other stuff.
	 */
	
	//BasePage bp = new BasePage();
	private final By textboxUsername = By.id("txtUsername");
	private final By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
	private final By buttonLogin = By.id("btnLogin");
		
	public OrangeHRMLoginPage enterUserName(String username){
		sendKeys(textboxUsername, username, WaitStrategy.PRESENCE);
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password){
		sendKeys(textboxPassword, password, WaitStrategy.PRESENCE);
		return this;
	}
	
	
	public OrangeHRMHomePage clickLoginButton(){
		click(buttonLogin, WaitStrategy.CLICKABLE);
		return new OrangeHRMHomePage();
	}

	public String getTitle( ){
		return getPageTitle();
	}
	
}
