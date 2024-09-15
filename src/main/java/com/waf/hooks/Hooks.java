package com.waf.hooks;

import com.common.utilities.ConfigLoader;
import com.common.utilities.PropertyFileLoader;
import com.common.utilities.VideoManger;
import com.waf.context.TestContext;
import com.waf.factory.DriverFactory;
import com.waf.pages.e_commerce.place_orderpage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Hooks {
    private WebDriver driver;
    private final TestContext context;
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp(Scenario scenario) throws IOException, AWTException {
        logger.info("Starting Scenario: " + scenario.getName());
        try {
            // dbconfig.initilizeDb(); // Uncomment if needed
            context.cloader = new ConfigLoader();
            context.pfloader = new PropertyFileLoader();
            String environment = context.cloader.getProperty("environment");
            // String runMode = context.cloader.getProperty("runMode");
            VideoManger.startVideoRecording();
            driver = DriverFactory.initialization();
            context.driver = driver;
            context.place_orderpage = new place_orderpage(context.driver);
            System.out.println("Place Order Page initialized: " + context.place_orderpage);
            context.scenario = scenario;
            // context.dbexecutor = new dbexecutor(); // Uncomment if needed
            logger.info("Running tests on: " + environment + " environment");
            System.out.println(context.cloader.getProperty("remoteURL"));

            logger.info("Setup completed for scenario: " + scenario.getName());
        } catch (Exception e) {
            logger.error("Setup failed for scenario: " + scenario.getName(), e);
        }
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            logger.error("Scenario failed: " + scenario.getName());
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "screenshot");
            logger.error("Screenshot taken for scenario: " + scenario.getName());
        } else {
            logger.info("Scenario passed: " + scenario.getName());
        }
        try {
            if (context.driver != null) {
                logger.info("Stopping video recording.");
                VideoManger.stopVideoRecording("Open and maximize browser");
                logger.info("Closing browser.");
                context.driver.quit();
            }
        } catch (Exception e) {
            logger.error("Exception occurred during teardown: ", e);
        }
    }
}
