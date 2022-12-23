@HomePage
Feature: HomePage Validation

 @DateTimeValidation
  Scenario: Verify Current Date in the home page
    Given I launch the application
    When I am on the home page
    Then I should see the current date and Time in the home page
    
  @MenuColourValidation  
  Scenario: Verify Primary and Secondary navigation colours are same
  Given I launch the application
  When I click on the "Sport" navigation
  Then I should see both primary and secondary navigations are same in colour
  
  