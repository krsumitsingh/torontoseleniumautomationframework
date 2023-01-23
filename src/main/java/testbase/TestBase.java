package testbase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import resuablecomponents.ReadPropertyFile;

public class TestBase {
	
	protected TestBase() {
		
	}
	
	BrowserFactory browserfactory = new BrowserFactory();
	
	@BeforeMethod
	public void launchBrowser() throws IOException{	
		DriverFactory.getInstance().setDriver(browserfactory.createBrowserInstance(ReadPropertyFile.getPropertyKeyValue("browser")));
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverFactory.getInstance().getDriver().get(ReadPropertyFile.getPropertyKeyValue("url"));
	}
	
	@AfterMethod
	public void tearDown(){
		DriverFactory.getInstance().closeBrowser();
		System.out.println("chrome browser closed");
	}

}
