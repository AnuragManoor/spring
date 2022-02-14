package com.controller;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class productupload {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException
	{
	
		System.setProperty("webdriver.edge.driver","C:\\Users\\19031380\\MS Edge\\msedgedriver.exe");
		driver=new EdgeDriver();
	driver.get("https://hcs2-hybrisadmin.carestreamhealth.com/backoffice/login.zul");
	driver.findElement(By.name("j_username")).sendKeys("admin");
	driver.findElement(By.name("j_password")).sendKeys("nimda");
	driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/div/table/tbody/tr/td/table/tbody/tr[5]/td/div/button")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div/div/div[2]/button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/div[1]/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/div[2]/div/span/input")).sendKeys("products");
	//driver.navigate().to("https://www.google.com");
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/div[1]/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/div[3]/div/div/div/table/tbody/tr[2]/td/div/div[1]/span")).click();
}
}
