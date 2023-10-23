@Logout
Feature: Logout
  As a User
  I want to logout from my account
  So that i successfully to logout from my account

  Scenario: Logout Functionality
    Given I am on logged account
    When I Click Sidebar menu in top left corner
    And I click button logout
   Then I successfully to logout account