Feature: Create a Portfolio Scenario

  Scenario Outline: Scenario for at portfolio level

    Given go to a portfolio <portfolio>
    When click on add Scenario
    And give the details <name> <scenarios> <Toaster>
    Then check the Scenario created <name>
    Examples:
      | portfolio     | name       | scenarios             |Toaster|
      | "Portfolio A" | "Sel Test" | "Base Case,Base Case" |"Successfully Created Scenario"|
      | "Portfolio A" | "" | "Base Case,Base Case" |"Successfully Created Scenario"|
      | "Portfolio A" | "      " | "Base Case,Base Case" |"Successfully Created Scenario"|
      | "Portfolio A" | "!@#$%^&*" | "Base Case,Base Case" |"Successfully Created Scenario"|
      | "Portfolio A" | "@#$%^    #$%^&*" | "Base Case,Base Case" |"Successfully Created Scenario"|
      | "Portfolio A" | "Sel Testt" | "Base Case,Base Case" |"Successfully Created Scenario"|
      | "Portfolio A" | "Sel Test12" | "Base Case,Base Case" |"Successfully Created Scenario"|



