Feature: KPI Data at Portfolio level

  Scenario Outline: KPI Data Scenario Check

    Given go to a specific portfolio <portfolio>
    When capture the kpi Data and got to specific assets in portfolio
    And go to cashflows for data
    Then verify the Data
    Examples:
      | portfolio     |
      | "Portfolio A" |
      | "Portfolio B" |
      | "Portfolio C" |

