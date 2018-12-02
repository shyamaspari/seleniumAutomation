package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.packt.base.BasePageObject;

public class LoginPage extends BasePageObject {
	private String logInPageUrl = "https://the-internet.herokuapp.com/login";

	private String username = "tomsmith";
	private String password = "SuperSecretPassword!";
	By usernameLocater = By.id("username");
	By passwordLocater = By.cssSelector("input[name=password]");
	By loginButtonLocator = By.xpath("//button[@type='submit']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		openUrl(logInPageUrl);
	}
	
	public SecurePage login(){
		System.out.println("Entering username and Password");
		find(usernameLocater).sendKeys(username);
		find(passwordLocater).sendKeys(password);
		find (loginButtonLocator).click();
		return new SecurePage(driver);
	}
}
