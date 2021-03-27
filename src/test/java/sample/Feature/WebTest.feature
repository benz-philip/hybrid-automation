@WebSmokeTest
Feature: Regression test of jqueryui web application

  Background: Browser is launched
    Given user launches the website

  @DragNDrop
  Scenario: Verify user should be able Drag and Drop
    And user navigates to dropable from left menu
    Then user should be able to successfully drags and drop to the destination
    Then user closes the browser

  @Select
  Scenario: Verify user should be able to select the given items
    And user navigates to Selectable from left menu
    Then user selects the items from given menu
    Then user closes the browser

  @ControlGroup
  Scenario: Verify user should be able to select the car details and book the car
    And user navigates to Controlgroup from left menu
    Then user select the car details as "2" and "1"
    Then user books the car
    Then user closes the browser
