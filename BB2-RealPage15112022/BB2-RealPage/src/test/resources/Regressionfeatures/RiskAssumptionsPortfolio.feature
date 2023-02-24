Feature: Risk Assumptions in feature file

  Scenario Outline: Risk Assumptions in scenario
    Given go to protfolio <portfolio>
    When go to riskassumptions
    Then verify the data in risk assumptions <searchWord> <simulation>
    Examples:
      | portfolio     | searchWord           | simulation      |
      | "Portfolio B" | "Loan"               | "Discount Rate" |
      | "Portfolio B" | "Loa"                | "Discount Rate" |
      | "Portfolio B" | "Loan "              | "Discount Rate" |
      | "Portfolio B" | "Loan In"            | "Discount Rate" |
      | "Portfolio B" | "Loan Intreset Rate" | "Discount Rate" |
#      | "Portfolio B" | "loan"               | "Discount Rate" |
      | "Portfolio B" | "Dis"                | "Discount Rate" |
      | "Portfolio B" | "Disc"               | "Discount Rate" |
#      | "Portfolio B" | "disc"               | "Discount Rate" |
#      | "Portfolio B" | "dis"                | "Discount Rate" |
      | "Portfolio B" | "Discount Rate"      | "Discount Rate" |
#      | "Portfolio B" | ""               | "Discount Rate" |
#      | "Portfolio B" | "   "               | "Discount Rate" |
#      | "Portfolio B" | "@#$%^"               | "Discount Rate" |
#      | "Portfolio B" | "#$%^ ^&*()"               | "Discount Rate" |




