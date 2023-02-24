Feature: Risk Assumptions at asset level in feature file

  Scenario Outline: Risk Assumptions at asset level in scenario
    Given go to assets <asset>
    When go to riskassumption
    And verify data in risk models <name> <factor> <template> <Toaster>
    Then verify the data in risk assumption <searchWord> <simulation>
    Examples:
      | asset           | searchWord | simulation           | name                | factor               | template        | Toaster                      |
      | "Premium Plaza" | "Loan"     | "Loan Interest Rate" | "Selenium Testtttt" | "Loan Interest Rate" | "Interest Rate" | "Successfully Created Model" |