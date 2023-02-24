Feature: Overview Feature in Portfolio

  Scenario Outline: Scenario to test the fields in Overview Tab for a specifiv Portfolio

    Given Go to a Specific Portfolio <portfolio>
    When Get the Data present in portfolio tab
    And Calculate the values
    Then compare the metrics

    Examples:
    |portfolio|
#    |"Portfolio P"       |
    |"Portfolio A"       |
#    |"Portfolio B"       |
#    |"test"|