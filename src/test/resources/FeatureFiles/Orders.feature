Feature: End to End scenarios for placing orders

	@Orders @One
	Scenario: Verify whether the User is able to place order
		Given I login to the application
		When I add any product to bag and checkout
		And I place an order
		Then I should see that the order is placed successfully
		
	