Feature: Add PortFolio

  Scenario Outline: Portfolio Adding Scenario
    Given Go to Portfolio Page
    When Create  New Portfolio <name> <type> <manager> <description>
    Then Verify the created Portfolio <name>

    Examples:
      | name          | type        | manager         | description           |
      | "Portfolio A" | "Mangement" | "Seema Kotecha" | "" |
      | "Portfolio B" | "Mangement" | "Seema Kotecha" | "" |
      | "Portfolio C" | "Mangement" | "Seema Kotecha" | "" |


