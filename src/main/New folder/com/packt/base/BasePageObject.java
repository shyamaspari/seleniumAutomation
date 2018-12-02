package com.packt.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageObject {
	protected WebDriver driver;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}

	protected void openUrl(String url) {
		System.out.println("openning page: " + url);
		driver.get(url);
		System.out.println("page opened! ");
	}
	
	protected WebElement find(By locater){
		return driver.findElement(locater);
	}
}
