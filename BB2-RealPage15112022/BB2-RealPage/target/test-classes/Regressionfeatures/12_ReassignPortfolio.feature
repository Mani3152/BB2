Feature: Reassign the portfolio feature

  Scenario Outline: Reassign Scenerio for Portfolio

    Given  Go to portfolios tab
    When  Select a portfolio to reassign <portfolio>
    And  reassign the asset to different portfolio <assets> <newPortfolio>
    Then  check whether the assets are reasigned or not <newPortfolio> <assets>

    Examples:
      | portfolio     | assets          | newPortfolio  |
      | "Portfolio B" | "Premium Plaza" | "Portfolio A" |