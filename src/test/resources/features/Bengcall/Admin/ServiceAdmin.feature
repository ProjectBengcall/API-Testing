@admin
Feature: Service admin on Bengcall

  #[API_BC_88]
  @demo
  Scenario Outline: Get view all service information type on admin with valid id
    Given Set view all service information type on admin with valid token and id <id>
    When  Send request get all service information on admin
    Then  Api should return response 200 OK
    And   Get all service information on admin assert json validation
    And   Get all service information on admin response contain Success get spesific service type
    Examples:
    |id|
    |2 |

    #[API_BC_89]

  Scenario Outline: Get all service information type on admin with invalid id using special character
    Given Set view all service information type on admin with special character on path <character>
    When  Send request get all service information on admin with special character id
    Then  Api should return response 500 Internal Server Error
    And   Get all service information on admin invalid id assert json validation
    And   Get all service information on admin response contain id not valid
    Examples:
    |character|
    |@#$%     |

  #[API_BC_90]
  Scenario Outline: Create new service type on admin with valid data
    Given Set Create new service on admin request body
    When  Send request create new service on admin
    Then  Api should return response 201 Created
    And   Post create new service type on admin assert json validation
    And   Post create new service on admin response contain <id>  <service_name>  <price>  <vehicle_id> and Success creating new service
    Examples:
    | id | service_name | price | vehicle_id |
    |3242|  Ganti Ban   | 35000 |      1     |

  #[API_BC_91]
  Scenario: Create new service type on admin with invalid data using empty value on vehicle id
    Given Set create new service on admin request body empty vehicle id value
    When  Send request create new service on admin
    Then  Api should return response 400 Bad Request
    And   Post create new service on admin invalid data assert json validation
    And   Post create new service on admin invalid response contain cannot bind input

  #[API_BC_92]
  Scenario: Create new service type on admin with invalid data using empty value on service name
    Given Set create new service on admin request body empty service name value
    When  Send request create new service on admin
    Then  Api should return response 400 Bad Request
    And   Post create new service on admin invalid data assert json validation
    And   Post create new service on admin invalid response contain there's input empty

  #[API_BC_93]
  Scenario: Create new service type on admin with invalid data using empty value on price
    Given Set create new service on admin request body empty price value
    When  Send request create new service on admin
    Then  Api should return response 400 Bad Request
    And   Post create new service on admin invalid data assert json validation
    And   Post create new service on admin invalid response contain cannot bind input

  #[API_BC_94]
  Scenario: Create new service type on admin with all the values empty
    Given Set create new service on admin request body with all empty values
    When  Send request create new service on admin
    Then  Api should return response 400 Bad Request
    And   Post create new service on admin invalid data assert json validation
    And   Post create new service on admin invalid response contain cannot bind input

  #[API_BC_95]
  Scenario Outline: Delete service type on admin with valid id
    Given Set delete service type on admin with valid token and id <id>
    When  Send request delete service type on admin
    Then  Api should return response 202 Accepted
    And   Delete service on admin assert json validation
    And   Delete service on admin response contain Success delete service type
    Examples:
    |id|
    |11 |
    |12|
    |13|

  #[API_BC_96]
  Scenario: Delete service type on admin without id
    Given Set delete service type on admin token
    When  Send request delete service type on admin without id
    Then  Api should return response 405 Method Not Allowed
    And   Delete service on admin assert json validation
    And   Delete service on admin response contain Method Not Allowed

  #[API_BC_97]
  Scenario Outline: Delete service type on admin using special character
    Given Set delete service type on admin with special character <character>
    When  Send request delete service type special character
    Then  Api should return response 500 Internal Server Error
    And   Delete service on admin assert json validation
    And   Delete service on admin response contain id not valid
    Examples:
    |character|
    |   @#    |
    |  &*()   |





