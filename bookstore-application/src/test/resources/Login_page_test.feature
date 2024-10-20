Feature: User Login

  Scenario Outline: Login as an existing user
    Given Open Login page
    When Fill out all fields with existing user data: "<userName>", "<password>"
    When Click the Login button
    Then Expected success login of "<userName>"

    Examples:
      |  userName  | password      |
      | John1234   | Ntesttest77!! |


  Scenario Outline: Login as a non-existing user
    Given Open Login page
    When Fill out all fields with non-existing user data: "<userName>", "<password>"
    When Click the Login button
    Then Expected error message

    Examples:
      |  userName  | password      |
      | InvalidUser   | Ninvalidtest77!! |


