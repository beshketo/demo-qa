Feature: User Registration

  Scenario Outline: Register new user
    Given Open Register page
    When Fill in the registration form with "<firstName>", "<lastname>", "<userName>", "<password>"
    When Check Captcha box
    When Click Register button
    Then Expected success message

    Examples:
      | firstName   | lastname | userName  | password      |
      | John   | New      | John123   | Ntesttest77!! |

  Scenario Outline: Submit registration form with empty fields
    Given Open Register page
    When Check Captcha box
    When Click Register button
    Then Expected all fields in red color