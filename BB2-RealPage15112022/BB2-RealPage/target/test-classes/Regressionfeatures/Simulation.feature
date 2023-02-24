Feature: Feature to check Backend Caluculations for simulations

  Scenario Outline: Scenrio to check Backend Caluculations for simulations

    Given Go to asset <asset>
    When Take the Cashflow values in Valuations
    And Insert these data into the excel <excel> <sheet> <seedValue>
    And Take the values in the other sheets of excel <B0> <B1>
    Then Compare the values with json
    Examples:
      | asset                | excel                | sheet           | seedValue | B0                      | B1                   |
      | "Skyview Apartments" | "disocunt_rate.xlsx" | "assetExpences" | "600"     | "0.0009464916739658647" | "0.1724161498477071" |
