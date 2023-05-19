  @log-in-the-system-and-get-an-error
  Scenario Outline: User gets an error when logging with wrong credentials
    Given the user is on the main page
    When the user clicks on 'make an appointment'
    And  the user enters <username> and <password> and tries to log in the system
    Then the user sees an <errorMessage>

    Examples:
      | username         | password | errorMessage                                                                                                                                                                                                                          |
      | John Doe       | 123456     | Login failed! Please ensure the username and password are valid.


  @create-an-appointment-in-Seoul
  Scenario Outline: User makes an appointment in Seoul
    Given the user is on the main page
    When the user clicks on 'make an appointment'
    And the user enters <username> and <password> and tries to log in the system
    And the user is successfully logged in
    And the user chooses a <facility>
    And the user selects Medicaid
    And the user picks a date
    Then the user books an appointment
    And the user gets summary of his appointment

    Examples:
      | username         | password | facility                                                                                                                                                                                                                          |
      | John Doe       | ThisIsNotAPassword     | Seoul CURA Healthcare Center


  @open-profile-and-check-its-under-construction
  Scenario Outline: User opens profile and its under construction
    Given the user is on the main page
    When the user clicks on 'make an appointment'
    And the user enters <username> and <password> and tries to log in the system
    And the user is successfully logged in
    And the user opens menu
    And the user opens profile and gets message

    Examples:
      | username         | password                                                                                                                                                                                                               |
      | John Doe       | ThisIsNotAPassword

 @create-an-appointment-and-check-it-in-history
 Scenario Outline: User creates an appointment and checks it in history tab
   Given the user is on the main page
   When the user clicks on 'make an appointment'
   And the user enters <username> and <password> and tries to log in the system
   And the user is successfully logged in
   And the user chooses a <facility>
   And the user selects Medicaid
   And the user picks a date
   Then the user books an appointment
   Then the user opens menu
   And the user opens history
   And the user checks the contents of an appointment card <facility>, <readmission>, <program>, <comment>

   Examples:
     | username | password | facility | readmission | program | comment |
     | John Doe | ThisIsNotAPassword  | Seoul CURA Healthcare Center | No | Medicaid | |

