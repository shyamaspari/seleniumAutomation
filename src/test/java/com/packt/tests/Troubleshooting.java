package com.packt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.packt.base.BaseTest;

public class Troubleshooting extends BaseTest {

	@Test
	public void WaitTest() {
		SoftAssert softassert=new SoftAssert();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		System.out.println("page opned ");
		WebElement StartButton = driver.findElement(By.xpath("//*[@id='start']/button"));
		StartButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish > h4")));
		WebElement finishText = driver.findElement(By.cssSelector("#finish > h4"));
		Assert.assertEquals(finishText.getText(), "Hello World!", "message not found");
		softassert.assertAll();
	}

	@Test
	public void VisiblityTest() {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		System.out.println("page opned ");
		WebElement StartButton = driver.findElement(By.xpath("//*[@id='start']/button"));
		System.out.println("is start button visible before : " + StartButton.isDisplayed());

		StartButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish > h4")));
		WebElement finishText = driver.findElement(By.cssSelector("#finish > h4"));
		Assert.assertEquals(finishText.getText(), "Hello World!", "message not found");
		System.out.println("is start button visible after :" + StartButton.isDisplayed());

	}

	@Test
	public void StaleElementTest() {
		driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
		System.out.println("page opned ");
		WebElement link = driver.findElement(By.linkText("Click here"));
		link.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
		WebElement message = driver.findElement(By.id("flash"));
		System.out.println("page message1 => " + message.getText());
		link = driver.findElement(By.linkText("Click here"));
		link.click();
		message = driver.findElement(By.id("flash"));
		System.out.println("page message2 => " + message.getText());
		link = driver.findElement(By.linkText("Click here"));
		link.click();
		message = driver.findElement(By.id("flash"));
		System.out.println("page message3 => " + message.getText());
		link = driver.findElement(By.linkText("Click here"));
		link.click();
		message = driver.findElement(By.id("flash"));
		System.out.println("page message4 => " + message.getText());

	}

	@Test
	public void otherTest() {
		driver.get("https://the-internet.herokuapp.com/large");
		System.out.println("page opned ");
		sleep(3000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// jsExecutor.executeScript("window.scrollBy(0,250)","");
		// sleep(3000);

		WebElement table = driver.findElement(By.cssSelector("#large-table"));

		jsExecutor.executeScript("arguments[0].scrollIntoView();", table);
		sleep(3000);

	}

	@Test
	public void hoversTest() {
		driver.get("https://the-internet.herokuapp.com/hovers");
		System.out.println("page opned ");

		WebElement picture = driver.findElement(By.xpath("//div[@class='figure']"));
		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'View profile')]"));

		Actions action = new Actions(driver);
		action.moveToElement(picture).build().perform();
		sleep(3000);
		action.moveToElement(link).click().build().perform();
		sleep(3000);

	}

	public void sleep(long millsec) {
		try {
			Thread.sleep(millsec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
