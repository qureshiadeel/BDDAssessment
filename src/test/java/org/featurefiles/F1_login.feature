Feature: User Login

  Background:
    Given the user is on the login page

  Scenario Outline: Login with valid credentials and Close App
    When the user enters the email "<email>" and password "<password>"
    And clicks the login button
    Then the user should be on the home page with the title "<title>"
    And the user closes the app

    Examples:
      | email                | password      | title    |
      | standard_user        | secret_sauce  | Products |

  Scenario Outline: Login with invalid credentials
    When the user enters the email "<email>" and password "<password>"
    And clicks the login button
    Then an error message should be displayed with the title "<title>"
    And the user closes the app


    Examples:
      | email              | password  |
      | invalid_email      | invalidpass |
