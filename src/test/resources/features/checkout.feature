Feature: Checkout product

  @Regression @Positive
  Scenario: User can checkout and payment product
    Given I is on cart page
    When I click checkout button
    And I input identity
    And I tap continue button
    And I tap finish button
    Then I is on checkout complete page

  @Regression @Negative
  Scenario: User can not checkout and payment product
    Given I is on cart page
    When I click checkout button
    And I input identity without postal code
    And I Click Continue Button to next process
    Then I get error message postal code is required

