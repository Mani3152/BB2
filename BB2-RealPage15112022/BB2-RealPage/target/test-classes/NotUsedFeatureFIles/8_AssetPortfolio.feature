Feature: Asset Portfolio Feature

  Scenario Outline: Asset Portfolio Scenario
    Given Go to an asset and change the portfolio for it <name> <portfolio>
    When Go to portfolios
    Then verify the asset are updated in the portfolios <name> <portfolio>
    Examples:
      | name | portfolio |
#      | ""   | ""        |
      | "Premium Plaza,Campus Edge" | "Portfolio A" |
#      | "Waterview Mall"                                                   | "Portfolio U" |
      | "Waterview Mall,Sugar Cane Apartments"                             | "Portfolio A" |
#      | "Waterview Mall"                                                   | "Portfolio U1" |
      | "Sugar Cane Apartments,Campus Edge,Sunrise Estates"                | "Portfolio B" |