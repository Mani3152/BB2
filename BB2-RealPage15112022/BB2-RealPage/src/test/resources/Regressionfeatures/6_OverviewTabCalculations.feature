Feature: feature to see OverviewTab Calculations

  @DEBTTab
  Scenario Outline: OverviewTab Calculations
    Given Go To Asset Page For DSCR <asset>
    When Verify DSCR and Occupancy
    Then validate DSCR and Occupancy

    Examples:
      | asset                   |
      | "Skyview Apartments"    |
      | "Premium Plaza"         |
      | "Sugar Cane Apartments" |
      | "Opengate Industrial"   |
