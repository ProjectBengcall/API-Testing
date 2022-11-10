Feature: Create comment for a service that has been completed
  Scenario Outline: Create comment for a service that has been completed with valid id
    Given Create comment service with input id 3 and comment "<comment>" and valid token
    When send request post comment with valid path
    Then Api should return response 201 Created
    And Put comment assert json validation
    And response body message "Success add comment", comment "<comment>"
    Examples:
      | comment |
      | service sangat rapi dan bagus |

  Scenario Outline: See all service history on user transactions with invalid path
    Given Create comment service with input id <id> and comment "<comment>" and valid token
    When send request post comment with invalid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And response body message "Not Found"
  Examples:
      | id | comment |
      | 5  | service sangat rapi dan bagus |
      | 6  | Montir kurang teliti          |

  Scenario: Create comment for a service that has been completed with id does not exist
    Given Create comment service with input id 4151 and comment "kurang baik servisnya" and valid token
    When send request post comment with valid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And response body message "Not Found"

  Scenario: Create comment for a service that has been completed with expired token
    Given Create comment service with input id 7 and comment "kurang baik servisnya" and expired token
    When send request post comment with valid path
    Then Api should return response 401 Unauthorized
    And response body failed assert json validation
    And response body message "invalid or expired jwt"

  Scenario: Create comment for a service that has been completed without input data on comment field
    Given Create comment service with input id 6 and comment "" and valid token
    When send request post comment with valid path
    Then Api should return response 400 Bad Request
    And Put comment assert json validation
    And response body message "Unsuccess add comment"

  Scenario: Create comment for a service that has been completed with invalid id (combine string, special character, numeric)
    Given Create comment service with input id "2d@" and comment "servis bagus sekali" and valid token
    When send request post comment with valid path
    Then Api should return response 400 Bad Request
    And Put comment assert json validation
    And response body message "Unsuccess add comment"








