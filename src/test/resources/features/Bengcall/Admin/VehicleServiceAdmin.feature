@admin
Feature: See the services available on a vehicle

  #[API_BC_98]
  @demo
  Scenario: See the services available on a vehicle with valid token
    Given Get all service on a vehicle with valid token
    When  send request get all service on a vehicle with valid path
    And   Api should return response 200 OK
    And   Get service on vehicle assert json validation
    And   Response body success should contain message success get all vehicle + service

  #[API_BC_99]

  Scenario: See the services available on a vehicle with invalid token
    Given Get all service on a vehicle with invalid token
    When  send request get all service on a vehicle with valid path
    And   Api should return response 401 Unauthorized
    And   response body failed assert json validation
    And   Response body invalid path should contain message invalid or expired jwt

  #[API_BC_100]
  Scenario: See the services available on a vehicle with invalid path
   Given Get all service on a vehicle with valid token
   When  send request get all service on a vehicle with invalid path
   Then  Api should return response 404 Not Found
   And   response body failed assert json validation
   And   Response body invalid path should contain message Not Found