Feature: Check motor vehicle stamp duty
@ui
  Scenario: validate motor vehicle registration calculation
    Given user is in check motor vehicle stamp duty page
    When clicks on the Check Online Button
    Then user will see Revenue NSW calculator page
    Given user click yes and enters vehicle amount
    When click the calculate button
    Then user will see valid contents in a pop up window

