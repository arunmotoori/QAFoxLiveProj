package com.tutorialsninja.automation.stepdef;

import org.junit.Assert;
import com.tutorialsninja.automation.framework.Browser;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.framework.Waits;
import com.tutorialsninja.automation.pages.CheckoutPage;
import com.tutorialsninja.automation.pages.HeadersPage;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.OrderSuccessPage;
import com.tutorialsninja.automation.pages.SearchResultsPage;
import com.tutorialsninja.automation.pages.ShoppingCartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Orders {
	
	HeadersPage headersPage = new HeadersPage();
	LoginPage loginPage = new LoginPage();
	SearchResultsPage searchResultsPage = new SearchResultsPage();
	ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
	CheckoutPage checkoutPage = new CheckoutPage();
	OrderSuccessPage orderSuccessPage = new OrderSuccessPage();
	
	@Given("^I login to the application$")
	public void i_login_to_the_application() {
		
		Browser.openApplicationURL();
		HeadersPage.navigateToLoginPage();
		LoginPage.doLogin();
		
	    
	}

	@When("^I add any product to bag and checkout$")
	public void i_add_any_product_to_bag_and_checkout()  {
		
		HeadersPage.searchProduct();
		SearchResultsPage.addFirstDisplayedProductToCart();
		HeadersPage.navigateToViewCartPage();
		ShoppingCartPage.navigateToCheckoutPage();
		
	    
	}

	@When("^I place an order$")
	public void i_place_an_order()  {
		
		CheckoutPage.placeOrder();
	
	}

	@Then("^I should see that the order is placed successfully$")
	public void i_should_see_that_the_order_is_placed_successfully()  {
		
		Waits.waitUntilElementLocated(10, OrderSuccessPage.successBreakcrumb);
		Assert.assertTrue(Elements.isDisplayed(OrderSuccessPage.successBreakcrumb));
	    
	}


}
