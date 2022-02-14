package com.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SG434 extends login {
	public static void main(String[] args) throws InterruptedException, IOException
	{
	System.setProperty("webdriver.edge.driver","C:\\Users\\19031380\\MS Edge\\msedgedriver.exe");
	US0110 t = new US0110();
	t.login();

	Select dropdown = new Select (driver.findElement(By.id("customerB2BUnit")));
	dropdown.selectByVisibleText("INSIGHT OCEANIA PTY LTD(0001079306) - Parts");
	WebDriverWait wait = new WebDriverWait(driver,5);
	wait.until(ExpectedConditions.elementToBeClickable(By.id("unitContinue"))).click();
	driver.findElement(By.id("input_SearchBox")).sendKeys("8618183");
	driver.findElement(By.className("siteSearchSubmit")).click();
	driver.findElement(By.id("8618183_plus")).click();
	driver.findElement(By.xpath("//*[@class='addToCartButton en']")).click();
	driver.findElement(By.xpath("//*[@id='cartimage']")).click();
	driver.findElement(By.xpath("//*[@class='bulk-link']")).click();
	driver.findElement(By.id("sku0")).sendKeys("8617060");
	driver.findElement(By.id("qty0")).sendKeys("1");
	driver.findElement(By.xpath("//*[@id='addBulkOrderFormToCartButtonFullPage']")).click();
	driver.findElement(By.xpath("//*[@class='plus alignPlus']")).click();
	driver.findElement(By.xpath("//*[@id='QuantityProduct_10']")).click();
	t.takeScreenshot(driver,"SG cart");

	driver.findElement(By.xpath("//*[@id='checkoutButtonBottom']")).click();
	Select dropdown1 = new Select (driver.findElement(By.id("paymentTypeSelect")));
	dropdown1.selectByVisibleText("Invoice");
	driver.findElement(By.id("PurchaseOrderNumber")).sendKeys("1234");
	//t.takeScreenshot(driver,"SG payment");
	driver.findElement(By.xpath("//*[@id='choosePaymentType_continue_button']")).click();
	driver.findElement(By.xpath("//*[@id='viewAddressBook']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='selectAddress']")).click();
	//t.takeScreenshot(driver,"SG shippingAddress");
	driver.findElement(By.xpath("//*[@id='continueAddress']")).click();
	driver.findElement(By.xpath("//*[@id=\"A4\"]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"dpick\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"requestedShipDatepicker\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"acceptableDeliverydatepicker\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"shippingMode1\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"portOfDestination\"]")).sendKeys("abc");
	driver.findElement(By.xpath("//*[@id=\"forwarderToUser\"]")).sendKeys("abc");
	driver.findElement(By.xpath("//*[@id=\"paymentMode\"]")).sendKeys("bcd");
	driver.findElement(By.xpath("//*[@id=\"addressContactNumber\"]")).sendKeys("def");
	
	Thread.sleep(5000);
	t.takeScreenshot(driver,"SG shippingMethod");
	driver.findElement(By.xpath("//*[@id='chooseDeliveryMethod_next_button']")).click();
	Thread.sleep(1000);
	//WebDriverWait wait1 = new WebDriverWait(driver,25);
	//WebElement a=wait1.until(ExpectedConditions.elementToBeClickable(By.id("chooseDeliveryMethod_continue_button")));
	t.takeScreenshot(driver,"SG review");
	driver.findElement(By.xpath("//*[@id='checkoutButton']")).click();
	t.takeScreenshot(driver,"SG orderConfirmation");
	driver.findElement(By.xpath("//*[@id='myAcc']")).click();
	driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/ul/li[2]/a")).click();
	t.takeScreenshot(driver,"SG orderHistory");
	driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div/div[4]/table/tbody/tr[1]/td[5]/div[1]/span[1]/a")).click();
	t.takeScreenshot(driver,"SG view");
	driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div/div/div[3]/div[3]/ul/li[2]/a/button")).click();
	String parent=driver.getWindowHandle(); 

	Set<String>s=driver.getWindowHandles();

	// Now iterate using Iterator
	Iterator<String> I1= s.iterator();

	while(I1.hasNext())
	{

	String child_window=I1.next();


	if(!parent.equals(child_window))
	{
	driver.switchTo().window(child_window);
	t.takeScreenshot(driver,"SG track");
	}




	}

	//driver.close();
	}
}
