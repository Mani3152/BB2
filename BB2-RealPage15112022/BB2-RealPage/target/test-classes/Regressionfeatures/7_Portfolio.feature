Feature: Add PortFolio

  Scenario Outline: Portfolio Adding Scenario
    Given Go to Portfolio Page
    When Create  New Portfolio <name> <type> <manager> <description>
    Then Verify the created Portfolio <name>

    Examples:
      | name           | type        | manager         | description             |
      | "portfolio P"  | "Mangement" | "Seema Kotecha" | "New Portfolio Created" |
      | ""             | "Mangement" | "Seema Kotecha" | "New Portfolio Created" |
      | "     "        | "Mangement" | "Seema Kotecha" | "New Portfolio Created" |
      | "!@#$%^&*("    | "Mangement" | "Seema Kotecha" | "New Portfolio Created" |
      | "portfolio P1" | "Mangement" | "Seema Kotecha" | ""                      |