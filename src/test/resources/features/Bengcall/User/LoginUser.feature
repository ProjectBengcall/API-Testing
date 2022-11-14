@User
Feature: Login as Customer
  #API_BC_8
  Scenario: Login customer with valid credentials
    Given post login customer with valid credentials
    When send request post login customer valid path
    Then Api should return response 202 Created
    And Post login customer success assert json validation
    And Response body should contain message "Success to login", fullname "Andika", role 0

  #API_BC_9
  Scenario: Login customer with invalid credentials (leave email field is empty)
    Given post Login customer with email field is empty
    When send request post login customer valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "password or email empty"

  #API_BC_10
  Scenario: Login customer with invalid credentials (leave password field is empty)
    Given post Login customer with password field is empty
    When send request post login customer valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "password or email empty"

  #API_BC_11
  Scenario: Login customer without credentials
    Given post Login customer without credentials
    When send request post login customer valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "password or email empty"

  #API_BC_12
  Scenario: Login new customer with invalid path
    Given post login customer with valid credentials
    When send request post login customer invalid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And Response body invalid path should contain message "Not Found"