Feature: Add a new Scenario

  Scenario Outline: To create a new Scenario

    Given Go to a particular asset <Asset>
    When Go to Details Tab and click on View Scenriao
    And Click add Scenerio and give the details <name> <status> <header> <notes> <valuations> <loans> <tenants>
    Then verify the created Scenraio <name>
    Examples:
      | Asset            | name        | status | header                     | notes   | valuations                                                                                                                                                        | loans                                                                                                                                                          | tenants                                                                                                                                                           |
      | "Selenium Testa" | "Sel Test1" | "yes"  | "Valuations,Loans,Tenants" | "notes" | "/home/uttham-vlit/Downloads/SingleAsset_Upload_With_EffectiveDate/SingleAsset_Upload_With_EffectiveDate/SkyView/410SkyView_30-06-2022/Cashflows_30-06-2022.xlsx" | "/home/uttham-vlit/Downloads/SingleAsset_Upload_With_EffectiveDate/SingleAsset_Upload_With_EffectiveDate/SkyView/410SkyView_30-06-2022/4Loans_30-06-2022.xlsx" | "/home/uttham-vlit/Downloads/SingleAsset_Upload_With_EffectiveDate/SingleAsset_Upload_With_EffectiveDate/SkyView/410SkyView_30-06-2022/10Tenants_30-06-2022.xlsx" |
