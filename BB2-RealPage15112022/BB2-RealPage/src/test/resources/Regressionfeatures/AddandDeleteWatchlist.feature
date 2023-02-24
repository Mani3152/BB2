
Feature: validate Addwatchlist

  Scenario Outline: vefify Addwatchlist
    Given user click on particular asset <particular_asset>
    When click on AddtoWatchlist <verify_asset> <message>
    And user click on particular_portfolio <portfolio>
    And click on Assets in Watchlist <message>
#    And Enter data value in search <message>

    Examples:
      | particular_asset     | portfolio     | verify_asset         | message              |
      | "Skyview Apartments" | "Portfolio C" | "Skyview Apartments" | "No data to display" |


  Scenario Outline: delete Addwatchlist
    Given user click particular asset <particular_asset>
    When Remove AddWatchList in particular asset <verify_asset>
    And click on particular_portfolio <portfolio>
    And click Asset in Watchlist <message>
    Then verify delete watchlist <message>
    Examples:
      | particular_asset     | portfolio     | message              | verify_asset         |
      | "Skyview Apartments" | "Portfolio C" | "No data to display" | "Skyview Apartments" |
