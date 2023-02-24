Feature: Search Asset in asset Page

  Scenario Outline: Scenario To Search an Asset
    Given Go to assets Page
    When Take all the assets Data
    Then enter in search box and check Whether its present or not <keyWords>
    And go to particular Asset <particular_asset> <data>
    And Search Tenant or Unit particular Asset  <data>
    And Search Loans in particular Asset <search_loan>

    Examples:
      | keyWords | particular_asset | data  | search_loan |
      | "pre"    | "Skyview Apartments"  | "2B1Ba" | "wel"      |