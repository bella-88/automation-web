@Login
Feature:Login function

  Scenario Outline: Verify login success after register account
    Given I navigate to Guru site
    When I click on here link and link to register page
#    And I input "<email>" and click submit button
#    And I get information to login

    Examples:
      | email           | password | userId     |
      | bella@gmail.com | UgenEjy  | mngr324325 |
