@User
Feature: See History of user's transaction
  #API_BC_45
  Scenario: See all service history on user transactions with valid token
    Given Get all service history with valid token
    When send request get all service history valid path
    Then Api should return response 200 OK
    And Get all service history assert json validation
    And response body message "Success get all transaction data"

  #API_BC_46
  Scenario: See all service history on user transactions with invalid path
    Given Get all service history with valid token
    When send request get all service history invalid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And response body message "Not Found"

  #API_BC_47
  Scenario: See all service history on user transactions with expired token
    Given Get all service history with expired token
    When send request get all service history valid path
    Then Api should return response 401 Unauthorized
    And response body failed assert json validation
    And response body message "invalid or expired jwt"