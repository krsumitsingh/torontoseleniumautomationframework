package testbase;

import org.openqa.selenium.WebDriver;

public final class DriverFactory {
	
	private DriverFactory() {
		
	}
	
	/*
	 * Singleton design Pattern
	   private constructor so that no one else can create object of this class
	 */
	private static DriverFactory instance = null;
	
	public static DriverFactory getInstance(){
		
		if(instance==null){
			
			instance = new DriverFactory();
		}	
		return instance;
		
	}
	
	//factory design pattern --> define separate factory methods for 
	//creating objects and create objects by calling that methods
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driverparam) {
		driver.set(driverparam);
	}
	
	public void closeBrowser(){
		driver.get().quit();
		driver.remove();
	}
	

}
