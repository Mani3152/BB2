Feature: validate RealPage

  Scenario Outline: Import AssetFile
    Given user click on Asset <AssetName>
    When click on import loan <Loan> <loanfilemessage> <loanToaster> <loansNames>
    And click on import Tenants <Tenant> <tenantFileMeesage> <tenantToaster> <tenantNames> <unit> <unitfileMessage> <unitToaster> <unitNames>
   # Then verify Asset
    Examples:
      | AssetName       | Loan                                                                    | loanfilemessage                      | loanToaster                   | loansNames                                                    | Tenant                                                                   | tenantFileMeesage                    | tenantToaster                   | tenantNames                                        |unit|unitfileMessage|unitToaster|unitNames|
      | "Premium Plaza" | "/home/uttham-vlit/Music/file imports/Premium_03-22/Premium_Loans.xlsx" | "Excel sheet validated successfully" | "Loans imported successfully" | "Wells Fargo Credit Line,Bank Of America,Citi Bank Refinance" | "/home/uttham-vlit/Music/file imports/Premium_03-22/Premium_Tenant.xlsx" | "Excel sheet validated successfully" | "Tenants imported successfully" | "Starbucks Retail,Starbucks Dark Store,Trader Joe" |""  |""             |""         |""       |