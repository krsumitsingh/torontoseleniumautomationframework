package com.toronto.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import factories.ExcelReaderFactory;
import pages.OrangeHRMLoginPage;
import testbase.TestBase;

public final class OrangeHRMTest extends TestBase {

	/*//div[text()='Amazon Prime Music']/parent::aAmazon Prime Music
	 * private String menuitems = "//div[text()='%value%']/parent::a";--XPATH constructed dynamically.
	 * public void clickMenu(String value){
	 * driver.findelement(By.xpath(menuitems.replace("%value%",value)));
	 */
	
	
	private OrangeHRMTest(){
		super();
	} 
	
	OrangeHRMLoginPage ohlp;
	
	//This methos used data read from config file
	/*
	@Test
	public void loginLogoutTest(){
		ohlp = new OrangeHRMLoginPage();
		String title=ohlp.enterUserName(ReadPropertyFile.getPropertyKeyValue("username"))
				.enterPassword(ReadPropertyFile.getPropertyKeyValue("password")).clickLoginButton()
				.clickWelcome().clickLogout()
				.getTitle();
		Assert.assertEquals("OrangeHRM", title);
		
	}*/
	
	
	@Test(dataProvider="LoginTestDataProvider",dataProviderClass=ExcelReaderFactory.class)
	public void loginLogoutTest(String username, String password){
		ohlp = new OrangeHRMLoginPage();
		String title=ohlp.enterUserName(username)
				.enterPassword(password).clickLoginButton()
				.clickWelcome().clickLogout()
				.getTitle();
		Assert.assertEquals("OrangeHRM", title);
		
	}
	
	
	
	



	
	
}
