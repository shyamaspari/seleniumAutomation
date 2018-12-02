package com.packt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.packt.base.BaseTest;

public class JavaScriptAlerts extends BaseTest {

	@Test
	public void testJSAlert() {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		System.out.println("page opned ");

		WebElement JSAlert = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button"));
		JSAlert.click();
		sleep(3000);
		driver.switchTo().alert().accept();
		sleep(3000);

		WebElement JSAlert2 = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button"));
		JSAlert2.click();
		sleep(3000);
		driver.switchTo().alert().accept();
		sleep(3000);

		WebElement JSAlert3 = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button"));
		JSAlert3.click();
		sleep(3000);
		driver.switchTo().alert().sendKeys("shyam");
		sleep(3000);
		driver.switchTo().alert().accept();
		sleep(3000);

	}

	public void sleep(long millsec) {
		try {
			Thread.sleep(millsec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
