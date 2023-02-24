Feature: Tenant Portfolio Feature

  Scenario Outline: Tenant Portfolio Scenario
    Given Go to portfolio and pick a portfolio <portfolio>
    When Go to properties for assets present in the portfolio under the tenants
    Then verify the tenants are updated in the portfolios <portfolio>
    Examples:
      | portfolio     |
      | "Portfolio A" |
