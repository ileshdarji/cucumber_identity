Feature: Vehicle Feature
  This feature deals with the aspersion of Car Registration and associated details

  Scenario Outline: Enter Car reg using scenario outline and compare the associated details
    Given I navigate to the vehicle inquiry page of DVLA
    When I enter <CarReg>
    Then I should see <Make> and <Colour>

      Examples:

        | CarReg   | Make     | Colour |
        | VO12HTN | CHEVROLET | SILVER |
        | VN63HKJ | VAUXHALL  | BROWN  |