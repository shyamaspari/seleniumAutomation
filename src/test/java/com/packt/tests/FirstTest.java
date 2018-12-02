package com.packt.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.LoginPage;
import com.herokuapp.SecurePage;
import com.packt.base.BaseTest;

public class FirstTest extends BaseTest {

	@Test
	public void firstTest() throws InterruptedException{
		LoginPage logInPage=new LoginPage(driver);
		logInPage.open();
		SecurePage securePage= logInPage.login();
		securePage.WaitForSecurePage(10);
		Assert.assertTrue(securePage.isLogOutButtonVisible(),"logout button is not displayed");
		Assert.assertTrue(securePage.getPageSource().contains("You logged into a secure area!"),"message not found in the page");
	}
}
