Feature: Login into facebook

  Scenario Outline: Invalid Scenario
    When I login with email "<email>" and password "<password>"
    Then I should be able to see error message on Login Page as "<Error Message>"
    Examples:
      | Note             | email                   | password     | Error Message                                                                              |
      | invalid email    | manthagrfgns@gmail.com  | abc@123      | The email address you entered isn't connected to an account. Find your account and log in. |
      | invalid password | neema.manthan@gmail.com | fvgsfgdhfjgj | The password that you've entered is incorrect. Forgotten password?                         |