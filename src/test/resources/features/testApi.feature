@regressionApi
Feature: Test bukalapak api

  @apiGet
  Scenario Outline: [GET] schema validator with data id=<id>
    Given user set data id as <id>
    When user get data with specific id
    Then the response should be have valid type data
    Examples:
      | id |
      | 3  |
      | 2  |
      | 1  |

  @apiPost
  Scenario Outline: [POST] add data to api
    Given user set data title as <title>
    And user set data body as <body>
    And user set data userId as <userId>
    When user add data to api
    Then the response title should be <title>
    And the response body should be <body>
    And the response userId should be <userId>
    Examples:
      | title         | body       | userId |
      | recomendation | motorcycle | 12     |