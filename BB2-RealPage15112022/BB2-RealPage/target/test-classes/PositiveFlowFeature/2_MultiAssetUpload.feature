Feature: Mutli asset imports

  Scenario Outline: Multi Asset Imports
    Given Go to properties page and click on import button
    When Upload the required Files <overview> <cashflow> <assumptions> <loan> <tenant> <overviewError> <cashflowError> <assumptionsError> <loanError> <tenantError>
    Then Submit the Data <Toastermsg>
    Examples:
      | overview                                                                          | overviewError                        | cashflow                                                                           | cashflowError                        | assumptions                                                                       | assumptionsError                     | loan                                                                           | loanError                            | tenant                                                                          | tenantError                          | Toastermsg                     |
      | "/home/uttham-vlit/Downloads/Multi Assset Upload Files/Multi_Overview-03_22.xlsx" | "Excel Sheet Validated successfully" | "/home/uttham-vlit/Downloads/Multi Assset Upload Files/Multi_Cashflows_03_22.xlsx" | "Excel Sheet Validated successfully" | "/home/uttham-vlit/Downloads/Multi Assset Upload Files/Multi_Overview-03_22.xlsx" | "Excel Sheet Validated successfully" | "/home/uttham-vlit/Downloads/Multi Assset Upload Files/Multi_Loans_03-22.xlsx" | "Excel Sheet Validated successfully" | "/home/uttham-vlit/Downloads/Multi Assset Upload Files/Multi_Tenant_03_22.xlsx" | "Excel Sheet Validated successfully" | "Assets imported successfully" |
