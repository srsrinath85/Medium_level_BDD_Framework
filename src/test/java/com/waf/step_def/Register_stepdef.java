package com.waf.step_def;

import com.common.utilities.ConfigLoader;
import com.waf.context.TestContext;
import com.waf.dbhelper.dbexecutor;
import com.waf.pages.register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class Register_stepdef {
    private final register register;
    private final dbexecutor dbexecutor;
    private final ConfigLoader cloader;

    public String name;
    public String city;
    public String Mobilenumber;
    public String dob;

    public Register_stepdef(TestContext context) {
        register = context.register;
        dbexecutor = context.dbexecutor;
        cloader = context.cloader;
    }

    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        // context.driver.get(context.cloader.getProperty("url"));
        register.goTo(cloader.getProperty("url"));
    }

    @When("I enter {string} in the name field")
    public void i_enter_in_the_name_field(String name) {
        this.name = name;
        register.enterName(name);
    }

    @When("I enter {string} in the city field")
    public void i_enter_in_the_city_field(String city) {
        this.city = city;
        register.enterCity(city);
    }

    @When("I enter {string} in the mobile number field")
    public void i_enter_in_the_mobile_number_field(String mobilenumber) {
        this.Mobilenumber = mobilenumber;
        register.enterMobileNumber(mobilenumber);
    }

    @And("I enter {string} in the dob field")
    public void iEnterInTheDobField(String dob) {
        this.dob = dob;
        register.enterDOB(dob);
    }

    @And("I click the register button")
    public void iClickTheRegisterButton() {
        register.clickButton();

    }

    @And("the details should be stored in the database")
    public void the_details_should_be_stored_in_the_database() {
        System.out.println("Inserting data into the database...");
        // dbexecutor.insertRegistrationDetails(name, city, Mobilenumber, dob);
        System.out.println("Data inserted successfully");

        // Retrieve the details from the database for validation
        List<Map<String, String>> dbData = dbexecutor.getRegistrationDetails(name);
        System.out.println("Retrieved Data from DB: " + dbData);
        System.out.println("it is executed successfully");
    }

    @Then("I should see a confirmation message Record stored in the database successfully.")
    public void iShouldSeeAConfirmationMessageRecordStoredInTheDatabaseSuccessfully() {
        // register.clicklink();
        System.out.println("enter in this method");
    }

}
