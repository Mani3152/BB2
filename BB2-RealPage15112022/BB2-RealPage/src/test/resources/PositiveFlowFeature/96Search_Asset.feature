Feature: Search Asset in asset Page

  Scenario Outline: Scenario To Search an Asset
    Given Go to assets Page
    When Take all the assets Data
    Then enter in search box and check Whether its present or not <keyWords>
    Examples:
      | keyWords |
      | "pre"    |