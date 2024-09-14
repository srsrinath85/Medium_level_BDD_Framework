Feature: Checking the end-to-end funtionality of an e-commerce website.

  @test9
 Scenario Outline:To Verify if the user is able to place order using e-commerce website
    Given User Logged in  to the  e-commerce site with username "<username>" and password "<password>".
    When User click on the any product add to cart button in the products list.
    Then User click on add to cart icon.
    Then User click on checkout button.
    And  User enter "<first_name>" and "<last_name>" and "<postal_code>"
    Then User click on the Continue button.
    Then User click on Finish button.
    Then User click on logout option.

 Examples:
    |username|password|first_name|last_name|postal_code|
    |standard_user|secret_sauce|demo|demotest|560100   |