package com.waf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class register extends BasePage {

    private final By Name = By.name("name");
    private final By city = By.name("city");
    private final By mobilenumber = By.name("mobile");
    private final By dateofbirth = By.name("dob");
    private final By button = By.xpath("//input[@type='submit']");
    //private final By link = By.xpath("//a[@href='home.html']");

    public register(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        enterTextOnElement(Name, name);
    }

    public void enterCity(String City) {
        enterTextOnElement(city, City);
    }

    public void enterMobileNumber(String Mobilenumber) {
        enterTextOnElement(mobilenumber, Mobilenumber);
    }

    public void enterDOB(String dob) {
        enterTextOnElement(dateofbirth, dob);
        // clickOnElement(dateofbirth);
    }

    public void clickButton() {
        clickOnElement(button);
    }

//    public void clicklink() {
//        clickOnElement(link);
//    }

}
