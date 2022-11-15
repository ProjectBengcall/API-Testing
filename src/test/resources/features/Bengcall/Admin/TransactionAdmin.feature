@admin
Feature: Transaction Admin on Bengcall

  #[API_BC_63]
  @demo
  Scenario: Get detail transaction data on admin with valid id
    Given Get detail transaction data on admin with valid id 3
    When  Send request get detail transaction on admin
    Then  Api should return response 200 OK
    And   Get detail transaction data on admin assert json validation
    And   Get detail transaction data on admin response contain Success get detail transaction data

  #[API_BC_64]

  Scenario: Get detail transaction data on admin with invalid path
    Given Get detail transaction data on admin with token
    When  Send request get detail transaction on admin with invalid path
    Then  Api should return response 404 Not Found
    And   Get detail transaction data on admin invalid data assert json validation
    And   Get detail transaction data on admin response contain message Not Found

  #[API_BC_65]
  Scenario: Get detail transaction data on admin with special character
    Given Get detail transaction data on admin with special character and valid token @#$%
    When  Send request get detail transaction on admin with special character
    Then  Api should return response 400 Bad Request
    And   Get detail transaction data on admin invalid data assert json validation
    And   Get detail transaction data on admin response contain message @@

  #[API_BC_66]
  Scenario: Get detail transaction data on admin with invalid token
    Given Get detail transaction data on admin with invalid token 1
    When  Send request get detail transaction on admin
    Then  Api should return response 401 Unauthorized
    And   Get detail transaction data on admin invalid data assert json validation
    And   Get detail transaction data on admin response contain message invalid or expired jwt

  #[API_BC_67]
  Scenario: Get all transaction on admin with valid path
    Given Get all transaction on admin valid token
    When  Send request get all transaction data on admin
    Then  Api should return response 200 OK
    And   Get all transaction on admin with valid path assert json validation
    And   Get all transaction on admin response contain Success get all transaction data

  #[API_BC_68]
  Scenario: Get all transaction on admin with invalid path
    Given Get all transaction on admin valid token
    When  Send request get all transaction data on admin with invalid path
    Then  Api should return response 405 Method Not Allowed
    And   Get all transaction on admin invalid assert json validation
    And   Get all transaction on admin response contain Method Not Allowed

  #[API_BC_69]
  Scenario: Get all transaction on admin with invalid token
    Given Get all transaction on admin invalid token
    When  Send request get all transaction data on admin
    Then  Api should return response 401 Unauthorized
    And   Get all transaction on admin invalid assert json validation
    And   Get all transaction on admin response contain invalid or expired jwt

  #[API_BC_70]
  Scenario Outline: Update transaction data on admin with valid id
    Given  Set update transaction data on admin with valid token and form data <id>
    When   Send request update transaction data on admin
    Then   Api should return response 201 Created
    And    Update transaction data on admin assert json validation
    And    Update transaction data on admin response contain <invoice> <status> with message Success update transaction status
    Examples:
    |id| invoice | status|
    |1 |  61248  |   3   |

  #[API_BC_71]
  Scenario: Update transaction data in admin with invalid id special character
    Given Set update transaction data on admin with invalid id special character HAHA
    When  Send request update transaction data on admin with invalid id
    Then  Api should return response 500 Internal Server Error
    And   Update transaction invalid data on admin assert json validation
    And   Update transaction invalid data on admin response contain id not valid


  #[API_BC_72]
  Scenario Outline: Update transaction on admin with invalid token
    Given Set update transaction data on admin with valid <id> and invalid token
    When  Send request update transaction data on admin
    Then  Api should return response 401 Unauthorized
    And   Update transaction invalid data on admin assert json validation
    And   Update transaction invalid data on admin response contain invalid or expired jwt
    Examples:
    |id|
    |3|

  #[API_BC_73]
  Scenario: Update transaction on admin with leave mandatory value in empty
    Given Set update transaction data on admin empty value data with id 1
    When  Send request update transaction data on admin
    Then  Api should return response 400 Bad Request
    And   Update transaction invalid data on admin assert json validation
    And   Update transaction invalid data on admin response contain BUG

  #[API_BC_74]
  Scenario Outline: Cancel transaction on admin with valid id
    Given Cancel transaction on admin with valid id <id>
    When  Send request cancel transaction data on admin
    Then  Api should return response 202 Accepted
    And   Cancel transaction on admin assert json validation
    And   Cancel transaction on admin response contain Success Cancel Transaction Service
    Examples:
    |id|
    |7 |
    |8 |

  #[API_BC_75]
  Scenario: Cancel transaction on admin with special character id
    Given Cancel transaction on admin with special character id @#$
    When  Send request cancel transaction data on admin
    Then  Api should return response 500 Internal Server Error
    And   Cancel transaction on admin assert json validation
    And   Cancel transaction on admin response contain id not valid

  #[API_BC_76]
  Scenario Outline: Cancel transaction on admin with invalid token
    Given Cancel transaction on admin with invalid token and valid <id>
    When  Send request cancel transaction data on admin
    Then  Api should return response 401 Unauthorized
    And   Cancel transaction on admin assert json validation
    And   Cancel transaction on admin response contain invalid or expired jwt
    Examples:
    |id|
    |10|



