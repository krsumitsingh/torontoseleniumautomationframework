package com.toronto.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import testbase.DriverFactory;
import testbase.TestBase;


public final class LoginpageTest extends TestBase {
	
	private LoginpageTest() {
		
	}
	
	//never hard code
		//keep right things at the right places
		// coding conventions----
		/* class or interface - SumitSingh
		 * final constant values - SUMITSINGH OR SUMIT_SINGH
		 * method name - sumitSingh();
		 * packagename - sumitssingh
		 */

		
		@Test
		public void test1() {	
			DriverFactory.getInstance().getDriver().findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);	
			System.out.println(DriverFactory.getInstance().getDriver().getTitle());
		}
		
		@Test
		public void test2(){
			DriverFactory.getInstance().getDriver().findElement(By.name("q")).sendKeys("Sharon Stone",Keys.ENTER);	
			System.out.println(DriverFactory.getInstance().getDriver().getTitle());
		}
	
		
}
