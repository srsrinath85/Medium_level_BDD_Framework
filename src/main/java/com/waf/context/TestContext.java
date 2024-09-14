package com.waf.context;

import com.common.utilities.ConfigLoader;
import com.common.utilities.PropertyFileLoader;
import com.waf.dbhelper.dbexecutor;
import com.waf.pages.e_commerce.place_orderpage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class TestContext {
    public WebDriver driver;
    public PropertyFileLoader pfloader;
    public ConfigLoader cloader;
    public dbexecutor dbexecutor;
    public Scenario scenario;
    public place_orderpage place_orderpage;

}
