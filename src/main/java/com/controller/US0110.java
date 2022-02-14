
package com.controller;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class US0110 extends login {
	@Test
public void test1() throws InterruptedException
{
System.setProperty("webdriver.edge.driver","C:\\Users\\19031380\\MS Edge\\edgedriver_win32.zip2022\\msedgedriver.exe");
US0110 t = new US0110();
t.login();

Select dropdown = new Select (driver.findElement(By.id("customerB2BUnit")));
dropdown.selectByVisibleText("CAPITAL XRAY INC(0000330152) - Parts");
WebDriverWait wait = new WebDriverWait(driver,5);
wait.until(ExpectedConditions.elementToBeClickable(By.id("unitContinue"))).click();
driver.findElement(By.id("input_SearchBox")).sendKeys("UNSP8G7106");
driver.findElement(By.className("siteSearchSubmit")).click();
driver.findElement(By.id("UNSP8G7106_plus")).click();
driver.findElement(By.id("addToCartButtonUNSP8G7106")).click();
driver.findElement(By.xpath("//*[@id='cartimage']")).click();
driver.findElement(By.xpath("//*[@class='bulk-link']")).click();
driver.findElement(By.id("sku0")).sendKeys("UN9G1313");
driver.findElement(By.id("qty0")).sendKeys("1");
driver.findElement(By.xpath("//*[@id='addBulkOrderFormToCartButtonFullPage']")).click();
driver.findElement(By.xpath("//*[@class='plus alignPlus']")).click();
driver.findElement(By.xpath("//*[@id='QuantityProduct_10']")).click();
//t.takeScreenshot(driver,"US cart");

driver.findElement(By.xpath("//*[@id='checkoutButtonBottom']")).click();
Select dropdown1 = new Select (driver.findElement(By.id("paymentTypeSelect")));
dropdown1.selectByVisibleText("Invoice");
driver.findElement(By.id("PurchaseOrderNumber")).sendKeys("1234");
//t.takeScreenshot(driver,"US payment");
driver.findElement(By.xpath("//*[@id='choosePaymentType_continue_button']")).click();
driver.findElement(By.xpath("//*[@id='viewAddressBook']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id='selectAddress']")).click();
//t.takeScreenshot(driver,"US shippingAddress");
driver.findElement(By.xpath("//*[@id='continueAddress']")).click();

Thread.sleep(1000);
//t.takeScreenshot(driver,"US shippingMethod");
driver.findElement(By.xpath("//*[@id='chooseDeliveryMethod_continue_button']")).click();
Thread.sleep(1000);
//WebDriverWait wait1 = new WebDriverWait(driver,25);
//WebElement a=wait1.until(ExpectedConditions.elementToBeClickable(By.id("chooseDeliveryMethod_continue_button")));
//t.takeScreenshot(driver,"US review");
driver.findElement(By.xpath("//*[@id='checkoutButton']")).click();
//t.takeScreenshot(driver,"US orderConfirmation");
driver.findElement(By.xpath("//*[@id='myAcc']")).click();
driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/ul/li[2]/a")).click();
//t.takeScreenshot(driver,"US orderHistory");
driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div/div[4]/table/tbody/tr[1]/td[5]/div[1]/span[1]/a")).click();
//t.takeScreenshot(driver,"US view");
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
//t.takeScreenshot(driver,"US track");
driver.findElement(By.id("lgout")).click();
Thread.sleep(200);
driver.close();
}



Thread.sleep(2000);
}

//driver.close();
}
}

