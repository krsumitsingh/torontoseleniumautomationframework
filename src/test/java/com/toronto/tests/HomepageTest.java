package com.toronto.tests;

import java.util.List;
import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.DriverFactory;
import testbase.TestBase;

public final class HomepageTest extends TestBase {
	
	private HomepageTest() {
		
	}
		
	/*
	 * validate whether the tile is containing Google Search or google search
	 * validate whether the title is not null and the length of the title is greater than 10 and < than 100
	 * check for the links in the pages-->Testing mini bytes - Youtube
	 * number of links displayed is exactly 10 or 15
	 */

	@Test
	public void test3() {	
		DriverFactory.getInstance().getDriver().findElement(By.name("q")).sendKeys("testing mini bytes - Youtube",Keys.ENTER);	
		String title = DriverFactory.getInstance().getDriver().getTitle();
		
		Assertions.assertThat(title)
		.isNotNull();
		/*.containsIgnoringCase("Google Search")
		.matches("\\w.*"+"google search")
		.hasSizeBetween(10, 15);*/
		
		
		//Assert.assertTrue(Objects.nonNull(title));
		//Assert.assertTrue(title.toLowerCase().contains("Google Search"));
		//Assert.assertTrue(title.toLowerCase().matches("\\w.*"+"google search"));    //[a-zA-Z0-9], w represents wordchar, . means any of [a-zA-Z0-9],* means number of occurrences
		//Assert.assertTrue(title.length()>10 && title.length()<100);
		boolean iSPresent=false;
		List<WebElement> elementLists = DriverFactory.getInstance().getDriver().findElements(By.xpath("//h3[text()='Testing Mini Bytes - YouTube']"));
		for(WebElement ele:elementLists){
			if(ele.getText().equalsIgnoreCase("Testing Mini Bytes - YouTube")){
				iSPresent=true;
				System.out.println(ele.getText());
				//break;
				
			}
		}
		Assert.assertTrue(iSPresent, "Testing mini Bytes - Youtube not found");
	}

}
