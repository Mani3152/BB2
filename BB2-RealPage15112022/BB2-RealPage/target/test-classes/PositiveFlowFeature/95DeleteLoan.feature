Feature: Delete a Lona feature

  Scenario Outline: Scenario to delete a loan
    Given Go to an asset <asset>
    When go to loans and select a loan to delete <loanName>
    Then delet the loan and verify <message>
    Examples:
      | asset            | loanName              | message |
      | "Selenium Testa" | "Citi Bank Refinance" | "Successfully Deleted Loan"      |