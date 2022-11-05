Feature: Login as Customer
  Scenario: Login customer with valid credentials
    Given post login customer with valid credentials
    When send request post login customer valid path
    Then Api should return response 202 Accepted
    And Post login user assert json validation

  Scenario: Login customer with invalid credentials (leave email field is empty)
    Given post Login customer with email field is empty
    When send request post login customer valid path
    Then Api should return response 400 Bad Request
    And Post login user with one credential empthy assert json validation

  Scenario: Login customer with invalid credentials (leave password field is empty)
    Given post Login customer with password field is empty
    When send request post login customer valid path
    Then Api should return response 400 Bad Request
    And Post login user with one credential empthy assert json validation

  Scenario: Login customer without credentials
    Given post Login customer without credentials
    When send request post login customer valid path
    Then Api should return response 400 Bad Request
    And Post login user with one credential empthy assert json validation

  Scenario: Login new customer with invalid path
    Given post login customer with valid credentials
    When send request post login customer invalid path
    Then Api should return response 404 Not Found
    And Post login user with invalid path assert json validation