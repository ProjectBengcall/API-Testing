@User
Feature: User Profile
  #API_BC_14
  @demo
  Scenario: GET a customer profile with valid token
    Given Get a customer profile with valid token
    When send request get customer profile valid path
    Then Api should return response 200 OK
    And Get customer profile assert json validation
    And Response body should contain message "success get my profile", fullname "Luqman Hanung Asidiq", images "https://bengcallbucket.s3.ap-southeast-1.amazonaws.com/profile/Q5aWl5c2RKoHcIFIrbMi-dummy450x450.jpg", email "luqmanhanung@gmail.com"

  #API_BC_15

  Scenario: GET a customer profile with expired token
    Given Get a customer profile with expired token
    When send request get customer profile valid path
    Then Api should return response 401 Unauthorized
    And response body failedd assert json validation
    And Response body invalid credentials should contain message "invalid or expired jwt"

  #API_BC_16
  Scenario: GET customer profile with invalid path
    Given Get a customer profile with valid token
    When send request get customer profile invalid path
    Then Api should return response 404 Not Found
    And response body failedd assert json validation
    And Response body invalid path should contain message "Not Found"

  #API_BC_17
  Scenario Outline: PUT Update customer profiled with valid credentials
    Given Update customer profile with valid token and input fullname "<fullname>", email "<email>", password "<password>" and image
    When send request put customer profile valid path
    Then Api should return response 202 Accepted
    And Put update customer profile valid token assert json validation
    And Response body should contain message "success update user", fullname "<fullname>", email "<email>"
  Examples:
    | fullname | email | password |
    | Luqman Hanung Asidiq | luqmanhanung@gmail.com | qwerty123 |


  #API_BC_18
  Scenario: PUT Update a customer profile with expired token
    Given Update a customer profile with expired token
    When send request put customer profile valid path
    Then Api should return response 401 Unauthorized
    And response body failedd assert json validation
    And Response body invalid credentials should contain message "invalid or expired jwt"

  #API_BC_19
  Scenario: PUT Update Customer profil with invalid path
    Given Update customer profile with valid token and input fullname "Tomi Prasetyo", email "tomipras@gmail.com", password "tomigreat112" and image
    When send request put customer profile invalid path
    Then Api should return response 404 Not Found
    And response body failedd assert json validation
    And Response body invalid path should contain message "Not Found"

  #API_BC_20
  Scenario: PUT Update Customer profile with password less than 8 characters
    Given Update customer profile with password less than 8 characters
    When send request put customer profile valid path
    Then Api should return response 500 Internal Server Error
    And response body failedd assert json validation
    And Response body invalid path should contain message "invalid password"

  #API_BC_21
  Scenario: PUT Update customer profiled without input all mandatory field
    Given Update customer profile without input all mandatory field
    When send request put customer profile valid path
    Then Api should return response 400 Bad Request
    And response body failedd assert json validation
    And Response body invalid path should contain message "please insert one field"

  #API_BC_22
  Scenario: DELETE Customer account with valid token
    Given Deactivate customer account with valid token
    When send request delete customer profile valid path
    Then Api should return response 202 Accepted
    And Delete customer accound assert json validation
    And Response body delete account should contain message "Success deactivate account"

  #API_BC_23
  Scenario: DELETE customer account with expired token
    Given Deactivate customer account with invalid token
    When send request delete customer profile valid path
    Then Api should return response 401 Unauthorized
    And response body failedd assert json validation
    And Response body invalid credentials should contain message "invalid or expired jwt"

  #API_BC_24
  Scenario: DELETE customer account with invalid path
    Given Deactivate customer account with valid token
    When send request delete customer profile invalid path
    Then Api should return response 404 Not Found
    And response body failedd assert json validation
    And Response body invalid path should contain message "Not Found"

  #API_BC_25
  Scenario: DELETE Customer account on customer account is already delete
    Given Deactivate customer account on customer account is already delete
    When send request delete customer profile valid path
    Then Api should return response 400 Bad Request
    And Delete customer accound assert json validation
    And Response body invalid path should contain message "not found"




