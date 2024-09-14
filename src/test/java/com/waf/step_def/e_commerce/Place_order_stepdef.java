package com.waf.step_def.e_commerce;

import com.common.utilities.ConfigLoader;
import com.waf.context.TestContext;
import com.waf.pages.e_commerce.place_orderpage;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Place_order_stepdef {
    private final ConfigLoader cloader;
    private final place_orderpage place_orderpage;
    private final Scenario scenario;



    public Place_order_stepdef(TestContext context){
        cloader=context.cloader;
        place_orderpage=context.place_orderpage;
        scenario= context.scenario;
    }


    @Given("User Logged in  to the  e-commerce site with username {string} and password {string}.")
    public void userLoggedInToTheECommerceSiteWithUsernameAndPassword(String user_name,String Password) {
       // System.out.println("printing");
        place_orderpage.goTo(cloader.getProperty("url1"));
        scenario.log("user is inside website");
        place_orderpage.enter_logindetails(user_name,Password);
        scenario.log("User enter username and password");
        place_orderpage.click_loginbtn();
        scenario.log("user click on login button.");


    }


    @When("User click on the any product add to cart button in the products list.")
    public void userClickOnTheAnyProductAddToCartButtonInTheProductsList() {
        place_orderpage.clickAddToCartButtonForProduct(4);
        scenario.log("user click on add cart button");

    }

    @Then("User click on add to cart icon.")
    public void userClickOnAddToCartIcon() {
        place_orderpage.click_cart();
        scenario.log("User click on cart icon");
    }

    @Then("User click on checkout button.")
    public void userClickOnCheckoutButton() {
        place_orderpage.click_checkout();
        scenario.log("user click on checkout button");
    }

    @And("User enter {string} and {string} and {string}")
    public void userEnterAndAnd(String fr_name,String Lname,String Pcode) {
        place_orderpage.enter_checkout_details(fr_name,Lname,Pcode);
        scenario.log("user enter firstname and lastname and postal code");
    }

    @Then("User click on the Continue button.")
    public void userClickOnTheContinueButton() {
        place_orderpage.click_continue();
        scenario.log("user click on continue button");

    }

    @Then("User click on Finish button.")
    public void userClickOnFinishButton() {
        place_orderpage.click_finishbtn();
        scenario.log("user click on finish button");
        String text=place_orderpage.getTextOnElement(By.className("complete-header"));
        System.out.println(text);
        Assert.assertEquals(text,"THANK YOU FOR YOUR ORDER");
    }

    @Then("User click on logout option.")
    public void userClickOnLogoutOption() {
        place_orderpage.click_logout();
        scenario.log("user click on logout button");
    }
}
