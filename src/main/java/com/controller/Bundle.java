


package com.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Bundle extends login {
	public static void main(String[] args) throws InterruptedException, IOException
	{
		System.setProperty("webdriver.edge.driver","C:\\Users\\19031380\\MS Edge\\msedgedriver.exe");
		 Bundle t = new Bundle();
		

		t.login();
	Select dropdown = new Select (driver.findElement(By.id("customerB2BUnit")));
	dropdown.selectByVisibleText("CAPITAL XRAY INC(0000330152) - Parts");
    WebDriverWait wait = new WebDriverWait(driver,5);
	wait.until(ExpectedConditions.elementToBeClickable(By.id("unitContinue"))).click();
	driver.findElement(By.id("input_SearchBox")).sendKeys("UNSP0030-354");
	driver.findElement(By.className("siteSearchSubmit")).click();
	driver.findElement(By.id("UNSP0030-354_plus")).click();
	driver.findElement(By.xpath("//*[@class='addToCartButton en']")).click();
	driver.findElement(By.id("cartimage")).click();
	driver.findElement(By.id("input_SearchBox")).sendKeys("XUCUS9010F");
	driver.findElement(By.className("siteSearchSubmit")).click();
	driver.findElement(By.xpath("//*[@class='button en']")).click();
	Thread.sleep(1000);
    t.takeScreenshot(driver,"cart conflict");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id=\"clrCartProceed\"]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"8620148andXUCUS9010FDet\"]")).click();
    
    t.takeScreenshot(driver,"pdp");
    driver.findElement(By.xpath("//*[@id=\"bundleCart\"]")).click();
    t.takeScreenshot(driver,"cart");
    driver.findElement(By.xpath("//*[@id=\"edit-btn\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"8621278andXUCUS9010FDet\"]")).click();
    t.takeScreenshot(driver,"updated pdp");
    driver.findElement(By.xpath("//*[@id=\"bundleCart\"]")).click();
    t.takeScreenshot(driver,"updated cart");
    driver.findElement(By.xpath("//*[@id='checkoutButtonBottom']")).click();
    Select dropdown1 = new Select (driver.findElement(By.id("paymentTypeSelect")));
    dropdown1.selectByVisibleText("Invoice");
    driver.findElement(By.id("PurchaseOrderNumber")).sendKeys("1234");
    t.takeScreenshot(driver,"Bundle payment");
    driver.findElement(By.xpath("//*[@id='choosePaymentType_continue_button']")).click();
    driver.findElement(By.xpath("//*[@id='viewAddressBook']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='selectAddress']")).click();
    t.takeScreenshot(driver,"Bundle shippingAddress");
    driver.findElement(By.xpath("//*[@id='continueAddress']")).click();
    driver.findElement(By.xpath("//*[@id='A1']")).click();
    WebDriverWait wait1 = new WebDriverWait(driver,25);
    WebElement a=wait1.until(ExpectedConditions.elementToBeClickable(By.id("chooseDeliveryMethod_continue_button")));
    t.takeScreenshot(driver,"Bundle shippingMethod");
    a.click();
    t.takeScreenshot(driver,"Bundle review");
    driver.findElement(By.xpath("//*[@id='checkoutButton']")).click();
    t.takeScreenshot(driver,"Bundle orderConfirmation");
    driver.findElement(By.xpath("//*[@id='myAcc']")).click();
    driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/ul/li[2]/a")).click();
    String x=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div/div[4]/table/tbody/tr[1]/td[1]")).getText();
    System.out.println(x);
    t.takeScreenshot(driver,"Bundle orderHistory");
    driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div/div[4]/table/tbody/tr[1]/td[5]/div[1]/span[1]/a")).click();
    t.takeScreenshot(driver,"Bundle view");

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
    t.takeScreenshot(driver,"Bundle track");
    }




    }

    
    
    
	
	
}
}





