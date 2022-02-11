@regressionLogin
Feature: Login bukalapak functionality

  Background: Browser is open and user on the login page
    Given user open bukalapak.com page
    And user clicks button login on the landing page
    Then user redirected to login page

  @positiveLogin
  Scenario Outline: Check login is successful with valid username and valid password credentials
    When user enters username with value <username>
    And user clicks on lanjut button
    Then user can see password textbox and login button
    When user enters password with value <password>
    And user clicks login button
    Then user is navigated to the home page
    Examples:
      | username            | password     |
      | test.wele@gmail.com | Testing12345 |

  @negativeLogin
  Scenario Outline: Check login is successful with valid username and invalid password credentials
    When user enters username with value <username>
    And user clicks on lanjut button
    Then user can see password textbox and login button
    When user enters password with value <password>
    And user clicks login button
    Then user see error message incorect password
    Examples:
      | username            | password           |
      | test.wele@gmail.com | ini-passwrod-salah |