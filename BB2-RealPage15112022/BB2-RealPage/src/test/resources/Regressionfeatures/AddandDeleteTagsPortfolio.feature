Feature: Add and Delete portfolio tag

  Scenario Outline: Addition and Deletion of portfolio tags
    Given Go to portfolio and click any portfolio <portfolio>
    When Click on SearchDropdown <keyword>
    And Click on Add Tag <addtags> <expected_toastmsg>
    Then Delete the Addedtags <deletetags> <expected_toastermsg>

    Examples:
      | portfolio     | addtags                                                        | expected_toastmsg        | deletetags                                                     | expected_toastermsg        | keyword |
      | "Portfolio C" | "Administrative and support,Educational services,Construction" | "Tag added successfully" | "Administrative and support,Educational services,Construction" | "Tag deleted successfully" | "bas"   |
      | "Portfolio C" | "Administrative and support,Educational services,Construction" | "Tag added successfully" | "Administrative and support,Educational services,Construction" | "Tag deleted successfully" | "base"  |
      | "Portfolio C" | "Administrative and support,Educational services,Construction" | "Tag added successfully" | "Administrative and support,Educational services"              | "Tag deleted successfully" | "bas"   |
      | "Portfolio C" | "Administrative and support,Educational services,Construction" | "Tag added successfully" | "Administrative and support,Construction"                      | "Tag deleted successfully" | "bas"   |
      | "Portfolio C" | "Administrative and support,Educational services"              | "Tag added successfully" | "Administrative and support,Educational services"              | "Tag deleted successfully" | "bas"   |
      | "Portfolio C" | "Administrative and support,Educational services,Construction" | "Tag added successfully" | "Administrative and support"                                   | "Tag deleted successfully" | "bas"   |
      | "Portfolio C" | "Administrative and support,Educational services,Construction" | "Tag added successfully" | "Construction"                                                 | "Tag deleted successfully" | "bas"   |
      | "Portfolio C" | "Administrative and support,Educational services,Construction" | "Tag added successfully" | "Administrative and support,Construction"                      | "Tag deleted successfully" | "base"  |
      | "Portfolio C" | "Administrative and support"                                   | "Tag added successfully" | "Administrative and support"                                   | "Tag deleted successfully" | "base"  |

