Feature: Delete an asset

  Scenario Outline: Delete Asset
    Given go to assets page
    When sleect an asset <name>
    Then Delete the assset <toaster>

    Examples:
      | name                 | toaster                      |
      | "Skyview Apartments" | "Successfully Deleted Asset" |