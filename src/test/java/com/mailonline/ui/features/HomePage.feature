@HomePage
Feature: HomePage Validation

 @DateTimeValidation
  Scenario: Verify Current Date in the home page
    Given I launch the application
    When I am on the home page
    Then I should see the current date and Time in the home page