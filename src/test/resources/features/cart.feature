@SecondRelease
Feature: Cart Product functionality

  @Positive
  Scenario: Ensure amount of card incremented when product added to cart

    Given I am on logged account
    When I add first product to cart
    And I see initial amount
    And I add second product to cart
    Then user verify amount of product in cart incremented
