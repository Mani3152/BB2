Feature: EditAssetPage

  Scenario Outline: EditAssetPage
    Given Opens RealPage  and user clicks on properties goes to a particular asset <particularAsset>
    When clicks on edit button and edit the values <name> <code> <country> <address> <city> <state> <zipcode> <category> <lifecycle> <marketValue> <manager> <fund> <portfolio> <acquisitionDate> <yearBuilt> <lastRefurbished> <currency> <unitofMeasure> <area> <valuationMethod>
    Then check the updated values <name> <code> <country> <address> <city> <state> <zipcode> <category> <lifecycle> <marketValue> <manager> <fund> <portfolio> <acquisitionDate> <yearBuilt> <lastRefurbished> <currency> <unitofMeasure> <area> <valuationMethod> <toaster>

    Examples:
      | particularAsset      | name | code | country | address | city | state | zipcode | category | lifecycle | marketValue | manager | fund | portfolio | acquisitionDate | yearBuilt | lastRefurbished | currency | unitofMeasure | area | valuationMethod | toaster                              |
      | "Selenium Testa" | ""   | ""   | ""      | ""      | ""   | ""    | "23452" | ""       | ""        | ""          | ""      | ""   | ""        | ""              | ""        | ""              | ""       | ""            | ""   | ""              | "Successfully Updated Asset Details" |
