Feature: validate portfolio

  Scenario Outline: verify portfolios
    Given click on particular Asset in dropdown <particular_asset>
    When verify portfolio <particular_asset>
    And click on Asset Tab <particular_asset>
    And verify portfolio in details Tab <message>
    And verify portfolio in search box <data> <error_msg>
    And click on particular portfolio <portfolio>
    And click on cardsTab and search Asset <Asset_data> <Category> <error_msg>
    And Search Loans for Asset level and portfolio level <particular_asset> <search_loan> <portfolio>
    And Search Tenants for Asset level and portfolio level <portfolio> <search_tenant>
    And Search Units for Asset level and portfolio level <multi_portfolio> <search_unit_summary> <search_unit_type>

    Examples:
      | particular_asset | message       | data  | portfolio     | Asset_data | Category | error_msg            | search_loan | search_tenant | multi_portfolio | search_unit_summary | search_unit_type |
      | "Premium Plaza"  | "Portfolio B" | "POr" | "Portfolio B" | "pre"      | "Office" | "No data to display" | "wel"       | "sta"         | "Portfolio C"   | "sky"               | "3b2"            |