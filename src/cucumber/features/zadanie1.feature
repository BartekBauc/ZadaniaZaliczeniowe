Feature: Zadanie1
  Scenario Outline: log in and fill addressfields

    Given niezalogowany uzytkownik jest na stronie glownej
    When kliknie w SignIn
    And zaloguje sie
    And doda adres
    Then Adres bedzie dodany
    Examples:
      |login    | haslo
