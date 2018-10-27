package com.tutorialsninja.automation.stepdef;

import org.junit.Assert;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.HeadersPage;
import com.tutorialsninja.automation.pages.SearchResultsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Search {
	
	HeadersPage headersPage = new HeadersPage();
	SearchResultsPage searchResultsPage = new SearchResultsPage();
	
	@When("^I search for a product \"([^\"]*)\"$")
	public void i_search_for_a_product(String product) {
		
		Elements.TypeText(HeadersPage.searchBoxField, product);
		Elements.click(HeadersPage.searchButton);
	    
	}

	@Then("^I should see the product in the search results$")
	public void i_should_see_the_product_in_the_search_results()   {
	    
		Assert.assertTrue(Elements.isDisplayed(SearchResultsPage.samsungSyncMasterSearchResult));
		
	}
	
	@Then("^I should see the page displaying the message \"([^\"]*)\"$")
	public void i_should_see_the_page_displaying_the_message(String message) {
	    
		Assert.assertTrue(Elements.VerifyTextEquals(SearchResultsPage.noResultsMessage, message));
		
	}

}
