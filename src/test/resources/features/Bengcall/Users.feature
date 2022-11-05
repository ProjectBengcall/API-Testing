Feature: Customer Profile
  Scenario: GET a customer profile with valid token
    Given Get a customer profile with valid token
    When send request customer profile valid path
    Then Api should return response 200 OK
    And Get customer profile assert json validation

  Scenario: GET a customer profile with expired token
    Given Get a customer profile with expired token
    When send request customer profile valid path
    Then Api should return response 401 Unauthorized
    And Get customer profile expired token assert json validation

  Scenario: GET customer profile with invalid path
    Given Get a customer profile with valid token
    When send request customer profile invalid path
    Then Api should return response 404 Not Found
    And Get customer profile invalid path assert json validation

  Scenario: PUT Update user profile with valid token and valid credentials
    Given Update customer profile with valid token
    When send request customer profile valid path
    Then Api should return response 201 Created
    And Put update customer profile valid token assert json validation

  Scenario: PUT Update a customer profile with expired token
    Given Update a customer profile with expired token
    When send request customer profile valid path
    Then Api should return response 401 Unauthorized
    And Get customer profile expired token assert json validation

  Scenario: Update Customer profil with invalid path
    Given Update customer profile with valid token
    When send request customer profile invalid path
    Then Api should return response 404 Not Found
    And Get customer profile invalid path assert json validation

  Scenario: Update Customer profile with password less than 8 characters
    Given Update customer profile with password less than 8 characters
    When send request customer profile valid path
    Then Api should return response 400 Bad Request

  Scenario: Delete Customer account with valid token
    Given Deactivate customer account with valid token
    When send request customer profile valid path
    Then Api should return response 200 OK

  Scenario: Delete user account with expired token
    Given Deactivate customer account with invalid token
    When send request customer profile valid path
    Then Api should return response 401 Unauthorized


