package com.AutomationTalks.demoProject1;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestClass1 
{
	public static WebDriver driver;
	
	@BeforeMethod
	public void launchDriver() throws IOException 
	{
		ChromeOptions options = new ChromeOptions();
		
		options.setPlatformName("WINDOWS");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Guru\\Desktop\\Drivers\\chromedriver.exe");
		 URL hubUrl = new URL("http://192.168.0.254:4444/wd/hub");
		 driver = new RemoteWebDriver(hubUrl, options);
			
		//driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().fullscreen();
		
	}
	@Test
	public void Test1()
	{
		driver.navigate().to("https://www.AutomationTalks.com");
		System.out.println("Test 1 Title is "+ driver.getTitle());
	}
	@Test
	public void Test2()
	{
		driver.navigate().to("https://www.AutomationTalks.com");
		System.out.println("Test 2 Title is "+ driver.getTitle());
	}
	@Test
	public void Test3()
	{
		driver.navigate().to("https://www.AutomationTalks.com");
		System.out.println("Test 3 Title is "+ driver.getTitle());
	}
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
}


