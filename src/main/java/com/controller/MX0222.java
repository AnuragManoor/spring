
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
public class MX0222 extends login {
public static void main(String[] args) throws InterruptedException, IOException
{
System.setProperty("webdriver.edge.driver","C:\\Users\\19031380\\MS Edge\\msedgedriver.exe");
MX0222 t = new MX0222();
WebDriver driver= new EdgeDriver();
driver.get("https://its-wwwtest.carestreamhealth.com/en/US/store/US-0110/");
driver.findElement(By.xpath("//*[@class='header_login_link']")).click();
driver.findElement(By.id("j_username")).sendKeys("t.jeffrey.nelson@carestream.com");
driver.findElement(By.id("j_password")).sendKeys("password123");
driver.findElement(By.id("signInBtn")).click();
Select dropdown = new Select (driver.findElement(By.id("customerB2BUnit")));
dropdown.selectByVisibleText("MEDICA SILLER, SA DE CV(0000566823)");
WebDriverWait wait = new WebDriverWait(driver,5);
wait.until(ExpectedConditions.elementToBeClickable(By.id("unitContinue"))).click();
driver.findElement(By.id("input_SearchBox")).sendKeys("8754145");
driver.findElement(By.className("siteSearchSubmit")).click();
driver.findElement(By.id("8754145_plus")).click();
driver.findElement(By.xpath("//*[@class='addToCartButton en']")).click();
driver.findElement(By.xpath("//*[@id='cartimage']")).click();
driver.findElement(By.xpath("//*[@class='bulk-link']")).click();
driver.findElement(By.id("sku0")).sendKeys("9970278");
driver.findElement(By.id("qty0")).sendKeys("1");
driver.findElement(By.xpath("//*[@id='addBulkOrderFormToCartButtonFullPage']")).click();
driver.findElement(By.xpath("//*[@class='plus alignPlus']")).click();
driver.findElement(By.xpath("//*[@id='QuantityProduct_10']")).click();
t.takeScreenshot(driver,"MX cart");
driver.findElement(By.xpath("//*[@id='checkoutButtonBottom']")).click();
driver.findElement(By.id("PurchaseOrderNumber")).sendKeys("1234");
t.takeScreenshot(driver,"MX payment");
driver.findElement(By.xpath("//*[@id='choosePaymentType_continue_button']")).click();
driver.findElement(By.xpath("//*[@id='viewAddressBook']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id='selectAddress']")).click();
t.takeScreenshot(driver,"MX shippingAddress");
driver.findElement(By.xpath("//*[@id='continueAddress']")).click();

Thread.sleep(1000);
t.takeScreenshot(driver,"MX shippingMethod");
driver.findElement(By.xpath("//*[@id='chooseDeliveryMethod_continue_button']")).click();
Thread.sleep(1000);
//WebDriverWait wait1 = new WebDriverWait(driver,25);
//WebElement a=wait1.until(ExpectedConditions.elementToBeClickable(By.id("chooseDeliveryMethod_continue_button")));
t.takeScreenshot(driver,"MX review");
driver.findElement(By.xpath("//*[@id='checkoutButton']")).click();
t.takeScreenshot(driver,"MX orderConfirmation");
driver.findElement(By.xpath("//*[@id='myAcc']")).click();
driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/ul/li[2]/a")).click();
t.takeScreenshot(driver,"MX orderHistory");
driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div/div[4]/table/tbody/tr[1]/td[5]/div[1]/span[1]/a")).click();
t.takeScreenshot(driver,"MX view");
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
t.takeScreenshot(driver,"MX track");
}




}

//driver.close();
}
}

