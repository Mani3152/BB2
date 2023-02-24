Feature: Data Sources Asset level

  Scenario Outline: Data Sources Asset Level
    Given go to asset <asset>
    When go to data sources in the asset <DatsSourcesSearch>
    Then verify the data in the asset <DatasetsSearch>
    Examples:
      | asset                   | DatasetsSearch | DatsSourcesSearch    |
      | "Sugar Cane Apartments" | "10-"          | "US "                |
      | "Sugar Cane Apartments" | "10-"          | "US F"               |
      | "Sugar Cane Apartments" | "10-"          | "US Fe"              |
      | "Sugar Cane Apartments" | "10-"          | "US Fed"             |
      | "Sugar Cane Apartments" | "10-"          | "US Federal Reserve" |
#      | "Sugar Cane Apartments" | "10-Year"      | "US "                |
      | "Sugar Cane Apartments" | "10-Y"         | "US "                |
      | "Sugar Cane Apartments" | "10-Ye"        | "US "                |
      | "Sugar Cane Apartments" | "1-Ye"         | "US "                |

