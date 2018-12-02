package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.packt.base.BasePageObject;

public class SecurePage extends BasePageObject {
	By LogOutButtonLocater = By.xpath("//a[@class='button secondary radius']");

	public SecurePage(WebDriver driver) {
		super(driver);

	}

	public void WaitForSecurePage(long millis) {
		System.out.println("Waititng for secure page");
		WebDriverWait wait = new WebDriverWait(driver, millis);
		wait.until(ExpectedConditions.presenceOfElementLocated(LogOutButtonLocater));
	}
	
	public boolean isLogOutButtonVisible(){
		return find(LogOutButtonLocater).isDisplayed();
	}
	public String getPageSource(){
		return driver.getPageSource();
	}

}
