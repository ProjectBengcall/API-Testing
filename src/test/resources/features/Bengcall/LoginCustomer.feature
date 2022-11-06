Feature: Login as Customer
  Scenario: Login customer with valid credentials
    Given post login customer with valid credentials
    When send request post login customer valid path
    Then Api should return response 202 Accepted
    And Post login customer success assert json validation
    And Response body should contain message "Success to login", fullname "Aksa", images "https://bengcallbucket.s3.ap-southeast-1.amazonaws.com/profile/Q5aWl5c2RKoHcIFIrbMi-dummy450x450.jpg", role 0,  token "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3NzQ4NTIzLCJpZCI6MTMsInJvbGUiOjB9.5xSTq8AN8oTvH6PN4zvEhjO4lSlLgj4Po6hm8ZtAdA8"

  Scenario: Login customer with invalid credentials (leave email field is empty)
    Given post Login customer with email field is empty
    When send request post login customer valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "password or email empty"

  Scenario: Login customer with invalid credentials (leave password field is empty)
    Given post Login customer with password field is empty
    When send request post login customer valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "password or email empty"

  Scenario: Login customer without credentials
    Given post Login customer without credentials
    When send request post login customer valid path
    Then Api should return response 400 Bad Request
    And response body failed assert json validation
    And Response body invalid credentials should contain message "password or email empty"

  Scenario: Login new customer with invalid path
    Given post login customer with valid credentials
    When send request post login customer invalid path
    Then Api should return response 404 Not Found
    And response body failed assert json validation
    And Response body invalid path should contain message "Not Found"