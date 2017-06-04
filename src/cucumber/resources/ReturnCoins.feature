Feature: Return Coins

  Scenario: Return will not return any coins if nothing has been inserted
    Given A Vending Machine is running
    Then the display shows "INSERT COIN"
    And the coin return has ""

  Scenario: Return will place equal change into the coin return
    Given A Vending Machine is running
    And I insert a Penny into the vending machine
    And I insert a Nickle into the vending machine
    And I insert a Dime into the vending machine
    And I insert a Quarter into the vending machine
    When I select the return coins button
    Then the display shows "INSERT COIN"
    And the coin return has "$0.41"

  Scenario: Returning change multiple times accumulates change in the coin return
    Given A Vending Machine is running
    And I insert a Quarter into the vending machine
    And I select the return coins button
    And I insert a Quarter into the vending machine
    When I select the return coins button
    Then the coin return has "$0.50"

  Scenario: Collecting change will empty the coin return
    Given A Vending Machine is running
    And I insert a Quarter into the vending machine
    And I select the return coins button
    When I collect change from the coin return
    Then the coin return has ""