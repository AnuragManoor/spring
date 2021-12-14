package com.controller;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class login {
	public static void takeScreenshot(WebDriver driver,String filename) throws IOException 
	{
	Screenshot screen=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
	ImageIO.write(screen.getImage(), "PNG", new File("C:\\Users\\19031380\\eclipse-workspace\\Bundleregression\\"+filename+".png"));
	}


}
