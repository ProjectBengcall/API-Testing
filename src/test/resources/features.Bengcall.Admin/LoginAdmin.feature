Feature: Login Admin on Bengcall


  Scenario: Admin login with valid credentials
   Given Admin login with valid request data
   When  Send request admin login
   Then  Api should return response 202 Accepted
   And   Post admin login valid credentials assert json validation
   And   Post admin login response should contain Success to login

  Scenario: Admin login with invalid credentials using unregistered email and password
    Given Admin login with invalid request data
    When  Send request admin login
    Then  Api should return response 400 Bad Request
    And   Post admin login invalid credentials assert json validation
    And   Post admin login response should contain email not found

  Scenario: Admin login with invalid credentials using empty email value
    Given Admin login with empty email value
    When  Send request admin login
    Then  Api should return response 400 Bad Request
    And   Post admin login with invalid value assert json validation
    And   Post admin login response should contain password or email empty

  Scenario: Admin login with invalid credentials using empty password value
    Given Admin login with empty password value
    When  Send request admin login
    Then  Api should return response 400 Bad Request
    And   Post admin login with invalid value assert json validation
    And   Post admin login response should contain password or email empty

  Scenario: Admin login with invalid credentials using special character on email and password value
    Given Admin login with special character
    When  Send request admin login
    Then  Api should return response 400 Bad Request
    And   Post admin login with invalid value assert json validation
    And   Post admin login response should contain email not found

  Scenario: Admin login with invalid credentials using empty email and password value
    Given Admin login with empty email and password value
    When  Send request admin login
    Then  Api should return response 400 Bad Request
    And   Post admin login with invalid value assert json validation
    And   Post admin login response should contain password or email empty

