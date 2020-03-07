#Author: syntax team (asel@syntaxtechs.com)
@sprint2 @addemployee
Feature: Add Employee

  Background: 
    Given I am logged into HRMS
    And I navigated to Add Employee Page

  @smoke1
  Scenario: Add new Employee
    When I add "John", "S" and "Smith"
    And I click Save
    Then I see Employee has been succesfully added

  @regression
  Scenario Outline: Add new Employee
    When I add "<FirstName>" "<MiddleName>" and "<LastName>"
    And I click Save
    Then I see Employee with "<FullName>" is displayed

    Examples: 
      | FirstName | MiddleName | LastName   | FullName       |
      | Robert    | F          | Kennedy    | Robert Kennedy |
      | Donald    | J          | Trump      |                |
      | Jimmy     |            | Carter     |                |
      | George    | J          | Washington |                |

  Scenario: Add Employee without employee id
    When I add "Leonardo", "D" and "DiCaprio"
    And I delete employee id
    And I click Save
    Then I see Employee with "Tim" is displayed

  @invalid
  Scenario: Add and Modify Employee Details
    When I enter employee details
      | FirstName | MiddleName | LastName |
      | Kidist    | J          | Johann   |
    And I click Save
    Then I am able to modify Employee Details
      | DriverLicense | ExpirationDate | SSN         | SIN     | Gender | MaritalStatus | Nationality | DOB        |
      | Y08787886     | 2021-12-08     | 123-45-6789 | 7687687 | Male   | Other         | Afghan      | 1980-10-10 |
      | Nhkjkgkhgkg   | 2018-12-08     | 565-45-6789 | 7687678 | Female | Married       | Burmese     | 1980-10-10 |
    And I click Save

  Scenario: AddEmployee and Login Credentials
    When I add "Sarah", "H" and "Bereket"
    And I click on create login checkbox
    And I enter username, password and confirm password
    Then I click Save
    
