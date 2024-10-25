Feature: Profile Page test


  Scenario Outline: Message is displayed on the profile page for unlogged-in user

    Given Open Profile page
    When The title is displayed on the profile page for unlogged-in user

  Scenario Outline: Check redirection to Login page after click on link on Profile page

    Given Open Profile page
    Then Click the login link in text on page
    When Login Page is opened after clicking the link

  Scenario Outline: Dashboard is opened for logged in user

    Given Open Profile page
    Then Click the login link in text on page
    Then Fill out all fields with existing user data: "<userName>", "<password>"
    Then Click the Login button
    When Empty dashboard is opened for logged-in user

    Examples:
      |  userName  | password      |
      | John1234   | Ntesttest77!! |