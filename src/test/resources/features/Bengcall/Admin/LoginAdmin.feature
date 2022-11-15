@admin
Feature: Login Admin on Bengcall

  #[API_BC_57]
  @demo
  Scenario: Admin login with valid credentials
   Given Admin login with valid request data
   When  Send request admin login
   Then  Api should return response 202 Accepted
   And   Post admin login valid credentials assert json validation
   And   Post admin login valid credentials response should contain fullname Admin Bengcall role 1 and message Success to login

  #[API_BC_58]

  Scenario: Admin login with invalid credentials using unregistered email and password
    Given Admin login with invalid request data
    When  Send request admin login
    Then  Api should return response 400 Bad Request
    And   Post admin login invalid credentials assert json validation
    And   Post admin login invalid response should contain email not found

  #[API_BC_59]
  Scenario: Admin login with invalid credentials using empty email value
    Given Admin login with empty email value
    When  Send request admin login
    Then  Api should return response 400 Bad Request
    And   Post admin login with invalid value assert json validation
    And   Post admin login invalid response should contain password or email empty

  #[API_BC_60]
  Scenario: Admin login with invalid credentials using empty password value
    Given Admin login with empty password value
    When  Send request admin login
    Then  Api should return response 400 Bad Request
    And   Post admin login with invalid value assert json validation
    And   Post admin login invalid response should contain password or email empty

  #[API_BC_61]
  Scenario: Admin login with invalid credentials using special character on email and password value
    Given Admin login with special character
    When  Send request admin login
    Then  Api should return response 400 Bad Request
    And   Post admin login with invalid value assert json validation
    And   Post admin login invalid response should contain email not found

  #[API_BC_62]
  Scenario: Admin login with invalid credentials using empty email and password value
    Given Admin login with empty email and password value
    When  Send request admin login
    Then  Api should return response 400 Bad Request
    And   Post admin login with invalid value assert json validation
    And   Post admin login invalid response should contain password or email empty

