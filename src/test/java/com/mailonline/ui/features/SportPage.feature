@SportsPage
Feature: Sports  

 Background:
    Given I launch the application
    And I navigate to "Football" from "sport" menu
    When I open the first article
    #
  #@ImageGalleryValidation
  #Scenario: Verify Image Gallery navigations of an article
    #And I Open the image gallery on full screen
    #Then I verify the arrow icons are working as expected
    
  @FaceBookModalValidation
  Scenario: Verify Facebook Dialog is opened when clicking on Facebook icon
    And I click on the facebook icon in the image gallery
    Then I verify the "facebook" modal dialog is opened
    
  #@VideoValidation
  #Scenario: Verify the embedded video can be viewed in fullscreen and minimized
  