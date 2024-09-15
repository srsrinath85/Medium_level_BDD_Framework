package com.waf.pages.e_commerce;

import com.waf.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class place_orderpage extends BasePage {

    public place_orderpage(WebDriver driver) {
        super(driver);
    }

    private final By uname = By.id("user-name");
    private final By pwd = By.id("password");
    private final By btn = By.id("login-button");
    private final By list = By.xpath("//div[@class='inventory_container']/div/div");
    private final By carticon = By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']");
    private final By checkout = By.xpath("//a[@class='btn_action checkout_button']");
    private final By fname = By.id("first-name");
    private final By lname = By.id("last-name");
    private final By pcode = By.id("postal-code");
    private final By ctn = By.xpath("//input[@type='submit']");
    private final By finishbtn = By.xpath("//a[@class='btn_action cart_button']");
    private final By ham_icon = By.xpath("//div[@class='bm-burger-button']");
    private final By logout = By.xpath("//a[@id='logout_sidebar_link']");

    public void enter_logindetails(String user_name, String Password) {
        enterTextOnElement(uname, user_name);
        enterTextOnElement(pwd, Password);

    }

    public void click_loginbtn() {
        clickOnElement(btn);
    }

    public void clickAddToCartButtonForProduct(int productIndex) {
        // Locate all product items
        List<WebElement> products = driver.findElements(list);

        // Check if the productIndex is within bounds
        if (productIndex <= 0 || productIndex > products.size()) {
            throw new IllegalArgumentException("Product index out of bounds");
        }

        // Retrieve the specific product
        WebElement product = products.get(productIndex - 1);

        // Find and click the 'Add to Cart' button within the specific product
        WebElement addToCartButton = product.findElement(By.xpath(".//button[contains(@class, 'btn_inventory')]"));
        addToCartButton.click();
    }

    public void click_cart() {
        clickOnElement(carticon);
    }

    public void click_checkout() {
        clickOnElement(checkout);
    }

    public void enter_checkout_details(String fr_name, String Lname, String Pcode) {
        enterTextOnElement(fname, fr_name);
        enterTextOnElement(lname, Lname);
        enterTextOnElement(pcode, Pcode);
    }

    public void click_continue() {
        clickOnElement(ctn);
    }

    public void click_finishbtn() {
        clickOnElement(finishbtn);
    }

    public void click_logout() {
        clickOnElement(ham_icon);
        clickOnElement(logout);
    }

}
