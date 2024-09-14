package com.waf.step_def;

import com.waf.context.TestContext;
import com.waf.factory.DriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Opening_demo {
    private final TestContext context;
    private final Scenario scenario;

    public Opening_demo(TestContext context)
    {
        this.context = context;
        this.scenario=context.scenario;
    }

    @Given("I open the browser")
    public void i_open_the_browser() throws IOException {
//        WebDriver driver = DriverFactory.initialization(context.cloader.getProperty("browser"));
//        context.driver = driver;
        context.driver.get(context.cloader.getProperty("url"));
    }

}
