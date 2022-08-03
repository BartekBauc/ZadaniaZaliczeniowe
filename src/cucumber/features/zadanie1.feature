Feature: Zadanie1

  Scenario Outline: log in and fill addressfields

    Given niezalogowany uzytkownik jest na stronie glownej
    When kliknie w SignIn
    And zaloguje sie
    And doda adres <alias> <address> <city> <zipcode> <country> <phone>
    Then adres jest poprawnie dodany
    Examples:
      | alias    | address         | city   | zipcode | country | phone     |
      | UserUser | BakerStreet221B | London | NW16XE  | U       | 123456789 |
