Feature: Vehicles Customer
  Scenario: See all types of vehicles available to be serviced with valid token
    Given Get See all types of vehicles available to be serviced with valid token
    When send request get vehicles valid path
    Then Api should return response 200 OK
    And Get vehicles assert json validation
    And Response body should contain message "success get all vehicle", data pertama id 1, data pertama name "125cc revo"

  Scenario: See all types of vehicles available to be serviced with expire token
    Given Get See all types of vehicles available to be serviced with expired token
    When send request get vehicles valid path
    Then Api should return response 401 Unauthorized
    And response body failed assert json validation
    And Response body invalid credentials should contain message "invalid or expired jwt"

  Scenario: See all types of vehicles available to be serviced with invalid path
    Given Get See all types of vehicles available to be serviced with valid token
    When send request get vehicles invalid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And Response body invalid path should contain message "Not Found"