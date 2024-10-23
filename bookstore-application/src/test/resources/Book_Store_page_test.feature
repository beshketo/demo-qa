Feature: Book Store test


  Scenario Outline: Find the book by title

    Given Open Book Store page
    When Fill out search field with part of title: "<part_title>"
    Then The book searched by title is displayed


    Examples:
      | part_title |
      | Learning JavaScript |


  Scenario Outline: Find the book by author

    Given Open Book Store page
    When Fill out the search field with name of author: "<author>"
    Then The book searched by author is displayed

    Examples:
      | author    |
      | Glenn Block et al. |

  Scenario Outline: Sort by DESK the book by author

    Given Open Book Store page
    When Click on the Author button
    Then All books are sorted by the name of the author

  Scenario Outline: List of books is displayed for login in user

    Given Open Book Store page
    When Click on the Login button on Book Store Page
    When Fill out all fields for login: "<userName>", "<password>"
    When Click on the Login button on Book Store Page
    Then User is logged in Account: "<userName>"

    Examples:
      | userName    | password    |
      | John1234 | Ntesttest77!!    |
