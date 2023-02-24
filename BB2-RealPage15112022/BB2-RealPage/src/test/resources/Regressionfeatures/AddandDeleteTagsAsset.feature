Feature: validate Tags

  Scenario Outline: Add tags
    Given click on assets <AssetName>
    When click on tags <Tags> <message>
    Then Remove tag <Tags> <del_message>
    Examples:
      | AssetName            | Tags                                                                              | message                  | del_message                |
      | "Skyview Apartments" | "Administrative and support,Educational services,Accommodation and food services" | "Tag added successfully" | "Tag deleted successfully" |
      | "Skyview Apartments" | "Administrative and support,Educational services"                                 | "Tag added successfully" | "Tag deleted successfully" |
      | "Skyview Apartments" | "Administrative and support,Accommodation and food services"                      | "Tag added successfully" | "Tag deleted successfully" |
      | "Skyview Apartments" | "Educational services,Accommodation and food services"                            | "Tag added successfully" | "Tag deleted successfully" |
      | "Skyview Apartments" | "Accommodation and food services"                                                 | "Tag added successfully" | "Tag deleted successfully" |
      | "Skyview Apartments" | "Administrative and support"                                                      | "Tag added successfully" | "Tag deleted successfully" |
      | "Skyview Apartments" | "Educational services"                                                            | "Tag added successfully" | "Tag deleted successfully" |
      | "Skyview Apartments" | "Administrative and support,Educational services,Accommodation and food services" | "Tag added successfully" | "Tag deleted successfully" |
      | "Skyview Apartments" | "Administrative and support,Educational services,Accommodation and food services" | "Tag added successfully" | "Tag deleted successfully" |
