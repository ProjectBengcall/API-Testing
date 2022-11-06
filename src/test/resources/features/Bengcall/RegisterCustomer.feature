Feature: Register new customer account
  Scenario: Register new customer with valid credential
    Given post register customer with valid credential
    When send request post register customer valid path
    Then Api should return response 201 Created
    And Response body should contain fullname "Sendi", email "sendi@gmail.com", message "Success create new user"
    And Post register customer assert json validation


  Scenario: Register new customer with password less than 8 characters
    Given post register customer with invalid password less than 8 characters
    When send request post register customer valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "invalid password or fullname"

  Scenario: Register new customer without credentials
    Given post register customer without credentials
    When send request post register customer valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "invalid password or fullname"

  Scenario: Register new customer with invalid path
    Given post register customer with valid credential
    When send request post register customer invalid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And Response body invalid path should contain message "Not Found"

  Scenario: Register new customer with one field mandatory is empty
    Given post register customer with one field mandatory is empty
    When send request post register customer valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "invalid password or fullname"

  Scenario: Register new customer with two field mandatory is empty
    Given post register customer with two field mandatory is empty
    When send request post register customer valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "invalid password or fullname"



