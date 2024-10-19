Feature: User Registration

  Scenario Outline: Register new user
    Given Open Register page
    When Fill in the registration form with "<firstName>", "<lastname>", "<userName>", "<password>"
    When Check Captcha box
    When Click Register button
    Then Expected success message

    Examples:
      | firstName   | lastname | userName  | password      |
      | John2   | New2      | John1234   | Ntesttest77!! |

  Scenario Outline: Submit registration form with empty fields
    Given Open Register page
    When Check Captcha box
    When Click Register button
    Then Expected all fields in red color


  Scenario Outline: Register a new invalid user
    Given Open Register page
    When Fill in the registration form with "<firstWrongName>", "<lastWrongName>", "<userWrongName>", "<wrongPassword>"
    When Check Captcha box
    When Click Register button
    Then Expected assert password message

    Examples:
      | firstWrongName   | lastWrongName | userWrongName  | wrongPassword      |
      | t   | t      | t   | t |
