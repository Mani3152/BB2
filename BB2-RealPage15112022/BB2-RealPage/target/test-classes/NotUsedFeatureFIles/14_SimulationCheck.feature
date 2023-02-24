Feature: Feature to check Backend Caluculations for simulations

  Scenario Outline: Scenrio to check Backend Caluculations for simulations

    Given Go to asset <asset>
    When Take the Cashflow values in Valuations
    And Insert these data into the excel <excel> <sheet> <seedValue>
    And Take the values in the other sheets of excel <excelOutput> <sheetOutput>
    Then Compare the values with json
    Examples:
      | asset            | excel                                                    | sheet                                                                                                                            | seedValue  | excelOutput                                 | sheetOutput                                                                                            |
#      | "Sunrise Estates" | "/home/uttham-vlit/Downloads/Simulations/disocunt_rate_SunriseEstates.xlsx" | "assetExpences"                              |"0.1028437"                |""                                                                |""                                                           |
      | "Sugar Cane Apartments" | "disocunt_rate.xlsx" | "assetExpences,Discount Rate,discountFactor,Discount Rate +1,expectedMarketValue,discountFactorOnAssetCashflow,fixedRandomValue" | "0.080999" | "/home/uttham-vlit/Music/CombinedFile.xlsx" | "discountRate,discountFactor,discountRatePlusOne,expectedMarketValue,unleveredCashflow,fixedRandomValue" |
