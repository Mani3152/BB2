Feature: Edit Portfolio Feature

  Scenario Outline: Edit Scenario for Portfolio
    Given Go to Portfolio and Pick a portfolio <portfolio>
    And Edit portfolio <portfolioname>
    Then Check weather the changes are made or not <portfolioname> <expected_toastermsg>

    Examples:
      | portfolio     | portfolioname  | expected_toastermsg              |
      | "Portfolio B" | "Portfolio Ce" | "Successfully Updated Portfolio" |
      | "Portfolio Ce" | "@#$%^&*("     | ""                               |
      | "Portfolio Ce" | ""             | ""                               |
      | "Portfolio Ce" | "      "       | ""                               |
      | "Portfolio Ce" | "@#$%  ^&*("   | ""                               |
