Feature: view Assets Check
  Scenario: check all directions

    Given Go to home page check it
    When Go to asset page check it
    And Go to asset details page check it<asset>
    And asset overview page check it
    And asset loans page
    And asset tenants page
    And asset dataSource page
    And asset risk assumptions page