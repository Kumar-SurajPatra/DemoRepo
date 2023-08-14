package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		Thread.sleep(3000);
		
	}

}
