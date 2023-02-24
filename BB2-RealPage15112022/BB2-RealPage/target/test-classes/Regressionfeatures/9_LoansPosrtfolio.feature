Feature: Loan Portfolio Feature

  Scenario Outline: Loan Portfolio Scenario
    Given Go to portfolio and pick the assets <portfolio>
    When Go to properties
    Then verify the loans are updated in the portfolios <portfolio>
    Examples:
      | portfolio      |
      | "Portfolio A"  |
#      | "portfolio U1" |
#      | "portfolio P"  |
      | "Portfolio B"  |
