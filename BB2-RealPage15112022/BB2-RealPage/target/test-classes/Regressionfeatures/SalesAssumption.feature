Feature: validate realpage edit sale

  Scenario Outline: vetify Edit Sale
    Given click Asset <particular_asset>
    When user click on valuation <Holding_Period> <Sale_Costs> <Terminal_Rate> <Sale_Price_Adjustment>
    Then veify Edit Sale <Holding_Period> <Sale_Costs> <Terminal_Rate> <Sale_Price_Adjustment>
    Examples:
      | particular_asset        | Holding_Period | Sale_Costs | Terminal_Rate | Sale_Price_Adjustment |
      | "Sugar Cane Apartments" | "10"           | "3.0"      | "2.2"         | "0"                   |
      | "Sugar Cane Apartments" | "9"            | "3.0"      | "2.2"         | "0"                   |
      | "Sugar Cane Apartments" | "11"           | "3.0"      | "2.2"         | "0"                   |
      | "Sugar Cane Apartments" | "10"           | "3.2"      | "2.2"         | "0"                   |
      | "Sugar Cane Apartments" | "10"           | "3.0"      | "2.1"         | "0"                   |
      | "Sugar Cane Apartments" | "10"           | "3.0"      | "2.2"         | "1"                   |
      | "Sugar Cane Apartments" | "10"           | "3.0"      | "2.3"         | "0"                   |
      | "Sugar Cane Apartments" | "10"           | "2.0"      | "2.2"         | "0"                   |
      | "Sugar Cane Apartments" | "8"            | "3.0"      | "2.2"         | "0"                   |
      | "Sugar Cane Apartments" | "10"           | "3.7"      | "2.2"         | "0"                   |
      | "Sugar Cane Apartments" | "10"           | "3.0"      | "2.0"         | "0"                   |