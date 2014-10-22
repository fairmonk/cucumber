Feature: To test putting products in bag and count their number

  Scenario: User chooses two products and puts them in bag
    Given I'm on the sportsdirect site
    When I navigate to "mega deals" page
    And I add item "Item1"
    And I navigate to "back" page
    And I add item "Item2"
    Then I should have "two" items in my bag

  Scenario: User goes into bag and adds another instance of a product
    Given I navigate to "my bag" page
    When I increase quantity for item by "1"
    And I press "Update Bag"
    Then I should have "four" items in my bag
