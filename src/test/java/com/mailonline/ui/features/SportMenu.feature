@tag
Feature: Football  

 Background:
    Given I launch the application
    And I navigate to "Football" from "Sport" menu
    When I open the first article   
    
  @ImageGalleryValidation
  Scenario: Verify Image Gallery of an article
    #Given I launch the application
    #And I navigate to "Football" from "Sport" menu   
    And I Open the image gallery on full screen
    Then I verify the arrow icons are working as expected
    
  @FaceBookModalValidation
  Scenario: Verify Facebook Dialog is opened when clicking on Facebook icon
    And I click on the "Facebook" icon in the image gallery
    Then I verify the "Facebook" modal dialog is opened
    
  @VideoValidation
  Scenario: Verify the embedded video can be viewed in fullscreen and minimized
  
    
   

  
