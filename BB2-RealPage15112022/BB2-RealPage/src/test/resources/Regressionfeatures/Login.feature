Feature: To Login

  Scenario Outline:Scenario to Login

    Given Enter the username and password <username> <password>
    When click on login
    Then verify true credentials verify home page or verofy the toaster if not <toaster> <name> <username> <password>
    Examples:
      | username     | password   | toaster                                   | name          |
      | "superadmin" | "Demo@123" | ""                                        | "Super Admin" |
      | "lona"       | "Demo@123" | "No User found with the username :: lona" | ""            |
      | "superadmin" | "Demo@"    | "Please Provide Valid Credentials"        | ""            |
      | ""           | ""         | ""                                        | ""            |
      | "superadmin" | ""         | ""                                        | ""            |
      | ""           | "124"      | ""                                        | ""            |