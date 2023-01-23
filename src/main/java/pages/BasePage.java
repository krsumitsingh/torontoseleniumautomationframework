package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import testbase.DriverFactory;

public class BasePage {

	WebElement element;
 

	protected void click(By by, WaitStrategy waitStrategy){
		element=ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.click();		
	}


	protected void sendKeys(By by, String value, WaitStrategy waitStrategy){
		element=ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.sendKeys(value);		
	}

	protected String getPageTitle(){		
		return DriverFactory.getInstance().getDriver().getTitle();		
	}


}
