@User
Feature: See available service type on one vehicle
  #API_BC_40
  @demo
  Scenario: See all service type with valid id vehicle
    Given Get see avalaible services with valid id vehicle 3
    When send request get services type customer with valid path
    Then Api should return response 200 OK
    And Get all services assert json validation
    And Response body should contain message "Success get spesific service type", id 3, service name "Ganti Velg", price 1900000, vehicle id 3

  #API_BC_41

  Scenario:  See all service type with id vehicle does not exist
    Given Get see avalaible services with valid id vehicle does not exist 3314
    When send request get services type customer with valid path
    Then Api should return response 500 Internal Server Error
    And response body failedd assert json validation
    And Response body invalid path should contain message "There's no ID"

  #API_BC_42
  Scenario: See all service type with invalid id (string/special Character/numeric)
    Given Get see avalaible services with invalid id vehicle "2w@"
    When send request get services type customer with valid path
    Then Api should return response 500 Internal Server Error
    And response body failedd assert json validation
    And Response body invalid path should contain message "id not valid"

  #API_BC_43
  Scenario: See all service type with invalid path
    Given Get see avalaible services with valid id vehicle 1
    When send request get services type customer with invalid path
    Then Api should return response 404 Not Found
    And response body failedd assert json validation
    And Response body invalid path should contain message "Not Found"

  #API_BC_44
  Scenario: See all service type with expired token
    Given Get see avalaible services with valid id vehicle 3 and expired token
    When send request get services type customer with valid path
    Then Api should return response 401 Unauthorized
    And response body failedd assert json validation
    And Response body invalid credentials should contain message "invalid or expired jwt"

