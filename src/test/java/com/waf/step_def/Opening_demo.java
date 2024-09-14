package com.waf.step_def;

import com.waf.context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class Opening_demo {
    private final TestContext context;
    private final Scenario scenario;

    public Opening_demo(TestContext context)
    {
        this.context = context;
        this.scenario=context.scenario;
    }

    @Given("I open the browser")
    public void i_open_the_browser() {
        context.driver.get(context.cloader.getProperty("url"));
        scenario.log("url is opened");
    }

}
