@sprint1 @login
Feature: Login

  @smoke
  Scenario: Valid login
    When I entered valid username and valid password
    And I click on login button
    Then I successfully logged in

  @regression
  Scenario: Invalid login
    Given I open browser and navigated to the HRMS
    When I entered valid username and invalid password
    And I click on login button
    Then I see error message
    And I close the browser

  @regression12
  Scenario Outline: Invalid Login and Message validation
    When I enter "<Username>" and "<Password>"
    And I click on login button
    Then I see "<ErrorMessage>"
    And I close the browser
    Examples: 
      | Username | Password      | ErrorMessage             |
      | Admin    | Admin123Wrong | Invalid Credentials      |
      | Admin    |               | Password cannot be empty |
      |          | Syntax@123    | Username cannot be empty |
      |          |               | Username cannot be empty |
    
