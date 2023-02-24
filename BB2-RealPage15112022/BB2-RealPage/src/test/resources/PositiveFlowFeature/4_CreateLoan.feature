Feature: feature to see Create Loan

  @CreateLoan
  Scenario Outline: create new Loan
    Given Go To LoansPage <asset>
    When Create New Loan <externalCode> <loanName> <lender> <servicer> <loanType> <leinPosition> <loanStatus> <originalBalance> <currentBalance> <originationDate> <maturityDate> <rateType> <rate> <daysConvention> <margin> <paymentType> <amStartDate> <amTerm> <amType> <Term>
    And Click On Add Loan Button
    Then Verify Loan Is Created <SuccessMessage> <loanName>

    Examples:
      | asset            | externalCode | loanName        | lender | servicer | loanType | leinPosition | loanStatus | originalBalance | currentBalance | originationDate | maturityDate | rateType | rate | daysConvention | margin | paymentType     | amStartDate  | amTerm | amType    | SuccessMessage              | LoanName    | Term |
      | "Selenium Testa" | "Test00012"  | "Test Loan Fixed" | "HSBC" | "12323"  | "Senior" | "1st"        | "Active"   | "10000000"      | "6500000"      | "08/01/2021"    | "08/01/2031" | "Fixed" | "3"  | "360/360"      | ""     | "Interest Only" | "08/01/2023" | "15"   | "360/360" | "Successfully Created Loan" | "Test Loan" | "12" |















































