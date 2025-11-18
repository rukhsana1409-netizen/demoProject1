package com.AutomationTalks.demoProject1;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass1 {
    public static WebDriver driver;
    public static final String USERNAME = "rukhsana_2Jz54B";
    public static final String ACCESS_KEY = "S6CQpTuszscY2woqstsw";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeMethod
    public void launchDriver() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "firefox");   // Proper casing, BrowserStack is case-insensitive but better to use standard
        caps.setCapability("browserVersion", "latest");   // or "117.0"


        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("os", "Windows");
        bstackOptions.put("osVersion", "11");
        bstackOptions.put("sessionName", "My Selenium 4 Test");
        bstackOptions.put("buildName", "Build 1");          // Optional but helps group sessions in dashboard
        bstackOptions.put("seleniumVersion", "4.33.0");     // Optional but recommended
        bstackOptions.put("video", true);                    // Enable video recording
        caps.setCapability("bstack:options", bstackOptions);

        driver = new RemoteWebDriver(new URL(URL), caps);
        System.out.println("BrowserStack Session ID: " + ((RemoteWebDriver) driver).getSessionId());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void Test1() {
        driver.get("https://www.AutomationTalks.com");
        System.out.println("Test 1 Title is " + driver.getTitle());
    }

    @Test
    public void Test2() {
        driver.get("https://www.AutomationTalks.com");
        System.out.println("Test 2 Title is " + driver.getTitle());
    }

    @Test
    public void Test3() {
        driver.get("https://www.AutomationTalks.com");
        System.out.println("Test 3 Title is " + driver.getTitle());
    }

    @AfterMethod
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
