package factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;
import enums.WaitStrategy;
import testbase.DriverFactory;

public final class ExplicitWaitFactory {
	
	private ExplicitWaitFactory(){
		
	}
	
	
	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by){
		WebElement element = null;
		if(waitStrategy==WaitStrategy.CLICKABLE){
			element = new WebDriverWait(DriverFactory.getInstance().getDriver(), FrameworkConstants.getTimeUnit())
			.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitStrategy==WaitStrategy.PRESENCE){
			element = new WebDriverWait(DriverFactory.getInstance().getDriver(), FrameworkConstants.getTimeUnit())
			.until(ExpectedConditions.presenceOfElementLocated(by));
		}else if(waitStrategy==WaitStrategy.VISIBLE){
			element = new WebDriverWait(DriverFactory.getInstance().getDriver(), FrameworkConstants.getTimeUnit())
			.until(ExpectedConditions.visibilityOfElementLocated(by));
		}else if(waitStrategy==WaitStrategy.NONE){
			element = DriverFactory.getInstance().getDriver().findElement(by);
		}
		return element;
		
		
	}
	
	

}
