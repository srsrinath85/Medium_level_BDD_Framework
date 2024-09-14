@test5
Feature: User Registration

#  As a user
#  I want to register on the website
#  So that my details are stored in the database

  Scenario Outline: Successful Registration with valid details
    Given I am on the registration page
    When I enter "<name>" in the name field
    And I enter "<city>" in the city field
    And I enter "<mobile>" in the mobile number field
    And I enter "<dob>" in the dob field
    And I click the register button
    Then the details should be stored in the database
    And I should see a confirmation message Record stored in the database successfully.

    Examples:
      | name       | city      | mobile     |dob|
      | user_new  | Bangalore  | 1234567890 |2014-08-11|

