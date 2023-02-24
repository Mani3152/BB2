Feature: Data Sources Portfolio level

  Scenario Outline: Data Sources Portfolio Level
    Given go to portfolio <portfolio>
    When go to data sources <DatsSourcesSearch>
    Then verify the data <DatasetsSearch>
    Examples:
      | portfolio     | DatasetsSearch | DatsSourcesSearch    |
      | "Portfolio C" | "10-"          | "US "                |
      | "Portfolio C" | "10-"          | "US F"               |
      | "Portfolio C" | "10-"          | "US Fe"              |
      | "Portfolio C" | "10-"          | "US Fed"             |
      | "Portfolio C" | "10-"          | "US Federal Reserve" |
#      | "Portfolio C" | "10-Year"      | "US "                |
      | "Portfolio C" | "10-Y"         | "US "                |
      | "Portfolio C" | "10-Ye"        | "US "                |
      | "Portfolio C" | "1-Ye"         | "US "                |
