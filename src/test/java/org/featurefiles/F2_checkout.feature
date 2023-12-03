Feature: Seamless Checkout Process

  Background:
    Given the application is open
    And the user is logged in
    And a product is added to the shopping cart

  Scenario Outline: Successfully Complete Checkout
    When the user navigates to the shopping cart
    And initiates the checkout process
    And  enters first name "<first>" and last name "<last>" and postal "<postal>" and proceeds by clicking the Continue button
    And  finalizes the purchase by clicking on the 'Finish' button
    Then the user should validate the displayed confirmation text
    And the user closes the application

    Examples:
      | first                | last          | postal    |
      | Adeel                | Qureshi       | 75850     |
