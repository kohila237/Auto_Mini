package com.Automation_Project;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot extends BaseClass{
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VIP\\eclipse-workspace\\Automation_Project\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		
		urlLaunch("https://the-internet.herokuapp.com/drag_and_drop");
		
		impWait(20);
		
		takeSnap("snapA.png");
		
	}
	
	
}
