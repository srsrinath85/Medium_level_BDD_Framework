package com.waf.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import static java.util.Objects.requireNonNull;

@CucumberOptions(features = { "src/test/resources/Features" }, glue = { "com.waf.hooks",
        "com.waf.step_def" }, plugin = { "pretty", "json:target\\Reports\\cucumber-report.json",
                "html:target\\cucumber\\cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setupBeforeClass() {
        requireNonNull(
                "D:\\Intellij workspace\\Web_Automation_Framework_cucumber\\src\\test\\resources\\configuration\\devconfig.properties",
                "credentials file not provided");
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
