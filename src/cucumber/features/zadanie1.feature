Feature: Zadanie1

  Scenario Outline: The user logs in and adds a delivery address.

    Given that the unlogged user is on the home page.
    When clicks "SignIn" button
    And logs in
    And adds a new address <alias> <address> <city> <zipcode> <country> <phone>
    Then confirmation that the address has been added correctly.
    Examples:
      | alias    | address         | city   | zipcode | country | phone     |
      | UserUser | BakerStreet221B | London | NW16XE  | U       | 123456789 |
