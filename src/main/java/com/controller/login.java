package com.controller;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class login {
	static WebDriver driver;
	public static void takeScreenshot(WebDriver driver,String filename) throws IOException 
	{
	Screenshot screen=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
	ImageIO.write(screen.getImage(), "PNG", new File("C:\\Users\\19031380\\eclipse-workspace\\Bundleregression\\"+filename+".png"));
	}

public static void login()
{
	driver=new EdgeDriver();
	driver.get("https://its-wwwtest.carestreamhealth.com/en/US/store/US-0110/");
	driver.findElement(By.xpath("//*[@class='header_login_link']")).click();
	driver.findElement(By.id("j_username")).sendKeys("t.jeffrey.nelson@carestream.com");
	driver.findElement(By.id("j_password")).sendKeys("password123");
	driver.findElement(By.id("signInBtn")).click();
}
}
