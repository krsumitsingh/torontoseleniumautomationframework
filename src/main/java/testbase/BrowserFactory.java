package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class BrowserFactory {
	
	protected BrowserFactory(){
		
	}
	
	WebDriver driver=null;
	public WebDriver createBrowserInstance(String browser){		
		if(browser.equalsIgnoreCase("Chrome")){
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);		
		}else if(browser.equalsIgnoreCase("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foptions = new FirefoxOptions();
			foptions.addArguments("-private");
			driver = new FirefoxDriver(foptions);
		}else if(browser.equalsIgnoreCase("msedge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		return driver;	
	}
}
