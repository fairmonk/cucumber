Feature: To test putting products in bag and count their number

  Scenario: User chooses two products and put them in bag
    Given I navigated to sportsdirect site
    When I add Slazenger Hooded Jacket Junior
    And I add No Fear Classic Jacket Junior
    Then I should have two items in my basket

  Scenario: User goes into bag and adds a few instances o product
    Given I navigate to bag
    When I increase quantity for the first item by a two
    And I press Update Bag
    Then I should have an updated number of items