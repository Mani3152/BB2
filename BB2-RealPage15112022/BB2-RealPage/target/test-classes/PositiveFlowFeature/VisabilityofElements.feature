Feature: validate elements
  Scenario Outline: verify elements is displayed
    Given verify elements <particular_Asset>
    Examples:
    |particular_Asset|
    |"Skyview Apartments"|