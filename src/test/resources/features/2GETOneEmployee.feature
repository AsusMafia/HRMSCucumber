Feature: Validating Syntax /getOneEmployee.php HRMS API

  Background: 
    Given user generates token

  @SyntaxHRMSAPIEndToEnd22
  Scenario: Retrieve created employee using /getOneEmployee.php API
    Given user calls getOneEmployee API 
    When User retrieves response for getOneEployee API
    Then status code is 200 for getOneEmployee API
    Then user validates created employee exists
