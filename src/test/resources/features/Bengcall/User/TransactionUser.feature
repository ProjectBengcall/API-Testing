Feature: Transaction user
  Scenario: Create new transaction with input all field mandatory
    Given Post create new transaction with input all field mandatory
    When send request post create transaction with valid path
    Then Api should return response 201 Accepted
    And Post create new transaction assert json validation
    And Response body success should contain message "Success creating new service"

  Scenario: Create new transaction with input all field mandatory and expired token
    Given Post create new transaction with input all field mandatory and expired token
    When send request post create transaction with valid path
    Then Api should return response 401 Unauthorized
    And response body failed assert json validation
    And Response body invalid credentials should contain message "invalid or expired jwt"

  Scenario: Create new transaction without input all field mandatory
    Given Post create new transaction without input all field mandatory
    When send request post create transaction with valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "cannot bind input"

  Scenario: Create new transaction with one field mandatory is empty
    Given Post create new transaction with one field mandatory is empty
    When send request post create transaction with valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "cannot bind input"

  Scenario: Create new transaction with two field mandatory is empty
    Given Post create new transaction with two field mandatory is empty
    When send request post create transaction with valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "cannot bind input"

  Scenario: Create new transaction with three field mandatory is empty
    Given Post create new transaction with three field mandatory is empty
    When send request post create transaction with valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "cannot bind input"

  Scenario: See ongoing user transaction with valid token
    Given Get ongoing user transaction with valid token
    When send request get ongoing user transaction valid path
    Then Api should return response 200 OK
    And Get ongoing user transaction assert json validation
    And Response body success should contain message "Success get my transaction"

  Scenario: See ongoing user transaction with invalid path
    Given Get ongoing user transaction with valid token
    When send request get ongoing user transaction invalid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And Response body invalid path should contain message "Not Found"

  Scenario: See ongoing user transaction with invalid token
    Given Get ongoing user transaction with expired token
    When send request get ongoing user transaction valid path
    Then Api should return response 401 Unauthorized
    And response body failed assert json validation
    And Response body invalid credentials should contain message "invalid or expired jwt"

  Scenario: See detail user's transaction with valid id
    Given Get detail user's transaction with id 1 and valid token
    When send requeat get detail transaction with valid path
    Then Api should return response 200 OK
    And Get detail transaction assert json validation
    And Response body success should contain message "Success get detail transaction data"

  Scenario: See detail user's transaction with id does not exist
    Given Get detail user's transaction with id 3194 and valid token
    When send requeat get detail transaction with valid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And Response body invalid path should contain message "Not Found"

  Scenario: See detail user's transaction with invalid id (combine string, numeric, and special character)
    Given Get detail user's transaction with invalid id "2d@" and valid token
    When send requeat get detail transaction with valid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And Response body invalid path should contain message "Not Found"

  Scenario: See detail user's transaction with invalid path
    Given Get detail user's transaction with id 1 and valid token
    When send requeat get detail transaction with invalid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And Response body invalid path should contain message "Not Found"

  Scenario: See detail user's transaction with expired token
    Given Get detail user's transaction with id 3 and expired token
    When send requeat get detail transaction with valid path
    Then Api should return response 401 Unauthorized
    And response body failed assert json validation
    And Response body invalid credentials should contain message "invalid or expired jwt"




