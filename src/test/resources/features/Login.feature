Feature: web testing selenium
  Scenario: Login Success on saucedemo
    Given Open web url "https://www.saucedemo.com/"
    And Input username "standard_user" and password "secret_sauce"
    When Click login button
    Then Should success Login and redirected to homepage
  Scenario Outline: Login success on saucedemo using scenario outline
    Given Open web url "https://www.saucedemo.com/"
    And Input username "<username>" and password "<password>"
    When Click login button
    Then Should success Login and redirected to homepage
    Examples:
    |username|password|
    |standard_user|secret_sauce|
    |standard_user|secret_sauce|
  Scenario Outline: login failed on saucedemo using scenario outline
    Given Open web url "https://www.saucedemo.com/"
    And Input username "<username>" and password "<password>"
    When Click login button
    Then Failed login and showing message
    Examples:
      |username|password|
      |standard_user|aaabbccddd|
      |standard_user|secret_sauce|

