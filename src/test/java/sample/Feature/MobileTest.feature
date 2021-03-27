@MobileSmokeTest
Feature: Regression Test of Selendroid Application

  @HomeScreenLaunch
  Scenario: Verify the elements on the screen
    Given Mobile app is launch and verifies the title screen
    And User verifies the home screen

  @ENButtonCheck
  Scenario: Check if the homepage is displayed
    Given Mobile app is launch and verifies the title screen
    And user clicks on EN button
    Then user selects option No
    And User verifies the home screen

  @VerifyCarMenu
  Scenario: Verify the car preference as default
    Given Mobile app is launch and verifies the title screen
    And user clicks on google chrome logo
    Then user verifies tittle
    And user verifies the text
    Then user enters the name in the textbox
    And user selects the preferred car as mercedes
    Then user clicks on send me your name button
    And verifies the confirmation text
    And user verifies the entered name and prefered car selected
    And user clicks on botton link
    Then user verifies for the default selected car

  @VerifyUserRegistration
  Scenario: Verify the elements on the user registration screen
    Given Mobile app is launch and verifies the title screen
    Then user clicks on show progress for a while
    And user waits for the progress bar to get disappeared
    Then user verifies all the elements on the screen

  @VerifyFileLogoUser
  Scenario: Submit user registration using file logo option
    Given Mobile app is launch and verifies the title screen
    Then user clicks on file logo button
    Then user verifies all the elements on the screen
    And user enters "Tim Horton" and "trest@gmail.com" and "Test@123" and "Mr. Burns"
    Then user clicks on register user button
    And User verifies the home screen

  @VerifyToastMessage
  Scenario: Verify toast message on the screen
    Given Mobile app is launch and verifies the title screen
    When user clicks on display toast button
    Then user verifies for toast message on the screen

  @UnHandledException
  Scenario: Handled Exception thrown from the application
    Given Mobile app is launch and verifies the title screen
    When user clicks on throw unhandled exception
    Then user verifies for app crash screen
    
  @TypeToThrowUnHandledException
  Scenario: Handled Exception thrown from the application when user input
    Given Mobile app is launch and verifies the title screen
    When user enters "test" in type to throw unhandled exception
       
   #@VerifyDismissPopup
  #Scenario: Verify Popup to be dismiss
    #Given Mobile app is launch and verifies the title screen
    #When user clicks on display popup window
    #Then user dismisses popup window
    
