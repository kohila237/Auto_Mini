package com.Automation_Project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass 
{
	public static WebDriver driver;
	//Select Browser------------------------------------------------------------
	public static WebDriver browserLaunch(String browserName) 
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Driver\\geckodriver\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		return driver;	
				
	}
	//Pass URL-----------------------------------------------------------------------
	public static void urlLaunch(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	//Actions(moveTo,right,double,click)-----------------------------------------------------------
	public static void actionMethod(WebElement element,String options) 
	{
		Actions act=new Actions(driver);
		
		if(options.equalsIgnoreCase("move"))
		{
			act.moveToElement(element).build().perform();
		}
		else if(options.equalsIgnoreCase("right"))
		{
			act.contextClick(element).build().perform();
		}
		else if(options.equalsIgnoreCase("double"))
		{
			act.doubleClick(element).build().perform();
		}
		else if(options.equalsIgnoreCase("click"))
		{
			act.click().build().perform();
		}
		else
		{
			System.out.println("not valid");
		}
		
	}
	//click-----------------------------------------------------------------------------
	public static void clickOnElement(WebElement element) 
	{
		element.click();
	}
	//windowHandling--------------------------------------------------------------------
	public static void windowHandles(String type,String dest) 
	{
		if(type.equalsIgnoreCase("single window"))
		{
			String windowHandle = driver.getWindowHandle();
			System.out.println(windowHandle);
		}
		else if(type.equalsIgnoreCase("multi window"))
		{
			Set<String> windowHandles = driver.getWindowHandles();
			System.out.println(windowHandles);
			
			for (String all : windowHandles) 
			{
				System.out.println(all);
				String title = driver.switchTo().window(all).getTitle();
				System.out.println(title);
			}
			
			String actualTitle=dest;
			
			for (String all : windowHandles) 
			{
				if(driver.switchTo().window(all).getTitle().equals(actualTitle))
				{
					break;
				}
			}
		}
		
	}
	
	//robotClass(up,down,left,right)------------------------------------------------------------------
	public static void robotClass(WebElement element,String options) throws AWTException 
	{
		Robot robo=new Robot();
		
		if(options.equalsIgnoreCase("up"))
		{
			robo.keyPress(KeyEvent.VK_UP);
			robo.keyRelease(KeyEvent.VK_UP);
			//robo.keyPress(KeyEvent.VK_ENTER);
		}
		else if(options.equalsIgnoreCase("down"))
		{
			robo.keyPress(KeyEvent.VK_DOWN);
			robo.keyRelease(KeyEvent.VK_DOWN);
			//robo.keyPress(KeyEvent.VK_ENTER);
		}
		else if(options.equalsIgnoreCase("left"))
		{
			robo.keyPress(KeyEvent.VK_LEFT);
			robo.keyRelease(KeyEvent.VK_LEFT);
			//robo.keyPress(KeyEvent.VK_ENTER);
		}
		else if(options.equalsIgnoreCase("right"))
		{
			robo.keyPress(KeyEvent.VK_RIGHT);
			robo.keyRelease(KeyEvent.VK_RIGHT);
			//robo.keyPress(KeyEvent.VK_ENTER);
		}
		else if(options.equalsIgnoreCase("enter"))
		{
			robo.keyPress(KeyEvent.VK_ENTER);
		}
		
		else
		{
			System.out.println("invalid");
		}
		
	}
	//dropDown(index,value,visibleText)---------------------------------------------------------------
	public static void dropDown(WebElement element,String options,String i)
	{
		Select sel=new Select(element);
		
		if(options.equalsIgnoreCase("index"))
		{
			sel.selectByIndex(Integer.parseInt(i));
		}
		else if(options.equalsIgnoreCase("value"))
		{
			sel.selectByValue(i);
		}
		else if(options.equalsIgnoreCase("text"))
		{
			sel.selectByVisibleText(i);
		}
		else
		{
			System.out.println("invalid");
		}
	}
	//sendKeys--------------------------------------------------------------------------------
	public static void sendKey(WebElement element,String input) 
	{
		element.sendKeys(input);

	}
	//javaScriptExecutor---Click---------------------------------------------------------------
	public static void jsClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	//javaScriptExecutor--Scroll(up,down)----------------------------------------------------------
	public static void scrollDown(WebElement element) 
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	//alert----------------------------------------------------------------------------------------
	public static void alert(WebElement element,String options) 
	{
		Alert al=driver.switchTo().alert();
		if(options.equalsIgnoreCase("accept"))
		{
			al.accept();
		}
		else if(options.equalsIgnoreCase("dismiss"))
		{
			al.dismiss();
		}
		else if(options.equalsIgnoreCase("text"))
		{
			String text = al.getText();
			System.out.println(text);
		}
	}
	//frame
	public static void frame(WebElement element,int index)
	{
	
		driver.switchTo().frame(index);
	}
	//implicitlyWait------------------------------------------------------------------------
	public static void impWait(int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	//refresh-------------------------------------------------------------------------------
	public static void refresh()
	{
		driver.navigate().refresh();
	}
	//TakeScreenShot----------------------------------------------------------------------------
	public static void takeSnap(String element) throws IOException 
	{
		TakesScreenshot snap=(TakesScreenshot) driver;
		File from = snap.getScreenshotAs(OutputType.FILE);
		File to=new File("C:\\Users\\VIP\\eclipse-workspace\\SeleniumConcept\\Snaps//"+element);
		FileUtils.copyFile(from, to);
	}
	//getOptions----------------------------------------------------------------------------
	public static void getOptions(WebElement element) 
	{
		Select s=new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement all : options) 
		{
			System.out.println(all);
		}
	}
	//isEnabled-------------------------------------------------------------------------------
	public static void isEnabled(WebElement element) 
	{
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}
	//isDisplayed---------------------------------------------------------------------------------
	public static void isDisplayed(WebElement element) 
	{
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}
	//getAttribute--------------------------------------------------------------------------------
	public static void getAttribute(WebElement element,String type) 
	{
		String attribute = element.getAttribute(type);
		System.out.println(attribute);
	}
	//close--------------------------------------------------------------------------------------
	public static void close() 
	{
		driver.close();
	}
	//quit------------------------------------------------------------------------------
	public static void quit() 
	{
		driver.quit();
	}
			
}	