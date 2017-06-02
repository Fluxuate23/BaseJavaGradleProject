Feature: Accept Coins

  Scenario: Default display says Insert Coin
    Given A Vending Machine is running
    Then the display shows "INSERT COIN"

  Scenario: Inserting a Penny is rejected
    Given A Vending Machine is running
    When I insert a Penny into the vending machine
    Then the display shows "INSERT COIN"

  Scenario: Inserting a Nickle adds five cents
    Given A Vending Machine is running
    When I insert a Nickle into the vending machine
    Then the display shows "$0.05"

  Scenario: Inserting a Dime adds ten cents
    Given A Vending Machine is running
    When I insert a Dime into the vending machine
    Then the display shows "$0.10"

  Scenario: Inserting a Quarter adds twenty-five cents
    Given A Vending Machine is running
    When I insert a Quarter into the vending machine
    Then the display shows "$0.25"

  Scenario: Inserting multiple coins accumulates the total and displays it
    Given A Vending Machine is running
    When I insert a Penny into the vending machine
    And I insert a Nickle into the vending machine
    And I insert a Dime into the vending machine
    And I insert a Quarter into the vending machine
    Then the display shows "$0.40"