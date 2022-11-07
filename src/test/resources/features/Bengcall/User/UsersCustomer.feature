Feature: Customer Profile
  Scenario: GET a customer profile with valid token
    Given Get a customer profile with valid token
    When send request get customer profile valid path
    Then Api should return response 200 OK
    And Get customer profile assert json validation
    And Response body should contain message "success get my profile", id 7 fullname "Ria", images "ria.png", email "Ria@gmail.com"

  Scenario: GET a customer profile with expired token
    Given Get a customer profile with expired token
    When send request get customer profile valid path
    Then Api should return response 401 Unauthorized
    And response body failed assert json validation
    And Response body invalid credentials should contain message "invalid or expired jwt"

  Scenario: GET customer profile with invalid path
    Given Get a customer profile with valid token
    When send request get customer profile invalid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And Response body invalid path should contain message "Not Found"

  Scenario: PUT Update customer profile with valid token and valid credentials
    Given Update customer profile with valid token
    When send request put customer profile valid path
    Then Api should return response 200 OK
    And Put update customer profile valid token assert json validation
    And Response body should contain message "Success update user", fullname "Risa", images "risa.png", email "risa@gmail.com"

  Scenario: PUT Update a customer profile with expired token
    Given Update a customer profile with expired token
    When send request put customer profile valid path
    Then Api should return response 401 Unauthorized
    And response body failed assert json validation
    And Response body invalid credentials should contain message "invalid or expired jwt"

  Scenario: PUT Update Customer profil with invalid path
    Given Update customer profile with valid token
    When send request put customer profile invalid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And Response body invalid path should contain message "Not Found"

  Scenario: PUT Update Customer profile with password less than 8 characters
    Given Update customer profile with password less than 8 characters
    When send request put customer profile valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid path should contain message "Bad Request"

  Scenario: DELETE Customer account with valid token
    Given Deactivate customer account with valid token
    When send request delete customer profile valid path
    Then Api should return response 200 OK
    And Delete customer accound assert json validation
    And Response body delete account should contain message "success deactivate account"

  Scenario: DELETE customer account with expired token
    Given Deactivate customer account with invalid token
    When send request delete customer profile valid path
    Then Api should return response 401 Unauthorized
    And response body failed assert json validation
    And Response body invalid credentials should contain message "invalid or expired jwt"

  Scenario: DELETE customer account with invalid path
    Given Deactivate customer account with valid token
    When send request delete customer profile invalid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And Response body invalid path should contain message "Not Found"

  Scenario: DELETE Customer account on customer account is already delete
    Given Deactivate customer account on customer account is already delete
    When send request delete customer profile valid path
    Then Api should return response 404 Not Found
    And Delete customer accound assert json validation
    And Response body invalid path should contain message "Not Found"


