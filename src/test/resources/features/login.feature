@FirstRelease
Feature: Login functionality

  @Positive
  Scenario Outline: Ensure user successfully login
    Given I am on the login page
    When I input <username> as username
    And I input <password> as password
    And I click button login
    Then I verify "<status>" login success result

    Examples:
      | username                | password      | status  |
      | standard_user           | secret_sauce  | success |
      | performance_glitch_user | secret_sauce  | success |

  @Negative
  Scenario Outline: Ensure user shows failed login error notification
    Given I am on the login page
    When I input <username> as username
    And I input <password> as password
    And I click button login
    Then I verify "<result>" login failed result

    Examples:
      | username        | password      | result          |
      |                 | secret_sauce  | blank_username  |
      | standard_user   |               | blank_password  |

