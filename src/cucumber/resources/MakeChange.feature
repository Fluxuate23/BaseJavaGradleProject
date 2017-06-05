Feature: Make Change

  Scenario: Purchasing an item with more than the required amount will output the remainder to coin return
    Given A Vending Machine is running
    And I insert 5 Quarters into the vending machine
    When I select the purchase cola button
    Then the coin return has "$0.25"
