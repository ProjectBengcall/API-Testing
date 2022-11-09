Feature: Vehicle admin on Bengcall

  Scenario: View all vehicle type on admin with valid path
    Given Get view all vehicle type on admin with valid path
    When  Send request view all vehicle type on admin
    Then  Api should return response 200 OK
    And   View all vehicle type on admin assert json validation
    And   Get view all vehicle type on admin response contain success get all vehicle


  Scenario: View all vehicle type on admin with invalid path
    Given Get view all vehicle type on admin with invalid path
    When  Send request view all vehicle type on admin invalid path
    Then  Api should return response 404 Not Found
    And   View all vehicle type on admin with invalid data assert json validation
    And   Get view all vehicle type on admin response contain Not Found

  Scenario: View all vehicle type on admin with invalid token
    Given Get view all vehicle type on admin with invalid token
    When  Send request view all vehicle type on admin
    Then  Api should return response 401 Unauthorized
    And   View all vehicle type on admin with invalid data assert json validation
    And   Get view all vehicle type on admin response contain invalid or expired jwt

#bug response typo
  Scenario: Create new vehicle type on admin with valid data
    Given Set create vehicle type on admin request data
    When  Send request create new vehicle type on admin
    Then  Api should return response 201 Created
    And   Post create new vehicle on admin with valid data assert json validation
    And   Get view all vehicle type on admin response contain sucses add vehicle

  Scenario: Create new vehicle type on admin with empty value on data
    Given Set create vehicle type on admin empty value request data
    When  Send request create new vehicle type on admin
    Then  Api should return response 400 Bad Request
    And   Post create new vehicle with on admin with invalid data assert json validation
    And   Post create create new vehicle type on admin response contain input empty

    #bug able to create vehicle type with special character
  Scenario: Create new vehicle type on admin with special character data
    Given Set create vehicle type on admin special character value request data
    When  Send request create new vehicle type on admin
    Then  Api should return response 400 Bad Request
    And   Post create new vehicle with on admin with invalid data assert json validation
    And   Post create create new vehicle type on admin response contain input empty

  Scenario: Create new vehicle type on admin with using invalid token
    Given Set create vehicle type on admin value request data with invalid token
    When  Send request create new vehicle type on admin
    Then  Api should return response 400 Bad Request
    And   Post create new vehicle with on admin with invalid data assert json validation
    And   Post create create new vehicle type on admin response contain invalid or expired jwt


  Scenario Outline: Delete vehicle type on admin with valid id
    Given Delete vehicle type on admin with valid id <id>
    When  Send delete new vehicle type on admin
    Then  Api should return response 202 Accepted
    And   Delete vehicle type on admin assert json validation
    And   Delete new vehicle type on admin response contain Success delete service type
    Examples:
    |id|
    |1 |
    |2 |
    |3 |

  Scenario: Delete vehicle type on admin without id
    Given Set valid admin token
    When  Send delete new vehicle type on admin without id
    Then  Api should return response 405 Method Not Allowed
    And   Delete vehicle type on admin assert json validation
    And   Delete new vehicle type on admin response contain Method Not Allowed

#Bug admin able delete vehicle special character id
  Scenario Outline: "Delete vehicle type on admin with invalid id using special character
    Given Delete vehicle type on admin with special character on id <character>
    When  Send delete new vehicle type on admin with special character
    Then  Api should return response 400 Bad Request
    And   Delete vehicle type on admin assert json validation
    And   Delete new vehicle type on admin response contain blabla
    Examples:
    |character|
    |   @#    |



