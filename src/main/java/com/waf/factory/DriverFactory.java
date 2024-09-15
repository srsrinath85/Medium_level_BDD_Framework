package com.waf.factory;

import com.common.utilities.ConfigLoader;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initialization() throws IOException {
        ConfigLoader configLoader = new ConfigLoader();
        String runmode = configLoader.getProperty("runMode");
        System.out.println(runmode);
        if (runmode.equalsIgnoreCase("local")) {
            initLocalWebDriver();
        } else if (runmode.equalsIgnoreCase("remote")) {
            initRemoteWebDriver();
        } else {
            System.out.println("the browser is not opening");
        }
        return driver;
    }

    public static WebDriver initLocalWebDriver() throws IOException {
        ConfigLoader configLoader = new ConfigLoader();
        String browserType = configLoader.getProperty("Browser");

        if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("the initlocal webdriver is not opening");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return driver;
    }

    public static WebDriver initRemoteWebDriver() throws IOException {
        ConfigLoader configLoader = new ConfigLoader();
        String remoteURL = configLoader.getProperty("remoteURL");
        // Initialize your remote WebDriver here
        System.out.println("Initializing remote WebDriver");
        // Example of setting up remote WebDriver with Selenium Grid or AWS EC2
        DesiredCapabilities caps = new DesiredCapabilities();
        String browserName = configLoader.getProperty("Browser"); // Ensure you implement this method to read from
        caps.setBrowserName(browserName);
        // properties

        try {
            driver = new RemoteWebDriver(new URL(remoteURL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

}
