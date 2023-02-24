Feature: Create a New Simulation

  Scenario Outline: Scenerio for New Simulation

    Given Go to a particular Asset <asset>
    When Go to Risk Assumptions
    And CLick on Simulations
    And Enter the Details
    Then Check the Simulation Results

    Examples:
      | asset                |
      | "Skyview Apartments" |