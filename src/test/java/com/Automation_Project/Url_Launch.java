package com.Automation_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Url_Launch extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VIP\\eclipse-workspace\\Automation_Project\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		
		driver=new ChromeDriver();	
		
		urlLaunch("https://www.instagram.com/accounts/login/");
		
		
		impWait(20);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		refresh();
	
		close();
		
		
	}
	
	
	
}
