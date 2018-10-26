package com.tutorialsninja.automation.stepdef;

import org.junit.Assert;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.ForgotPasswordPage;
import com.tutorialsninja.automation.pages.HeadersPage;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.MyAccountPage;

import cucumber.api.java.en.*;

public class Login {
	
	HeadersPage headersPage = new HeadersPage();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
	
	@And("^I naviage to Account Login page$")
	public void i_naviage_to_Account_Login_page()  {
	   
		Elements.click(HeadersPage.myAccountLink);
		Elements.click(HeadersPage.login);
		
	}

	@When("^I login to the application using Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void i_login_to_the_application_using_Username_and_Password(String username, String password)  {
		
		LoginPage.doLogin(username, password);
	    
	}

	@Then("^I should see that the User is able to successfully login$")
	public void i_should_see_that_the_User_is_able_to_successfully_login()  {
		
		Assert.assertTrue(Elements.isDisplayed(MyAccountPage.registerAffiliateAccount));
		
	}
	
	@Then("^I should see an error message informing the User about invalid credentials$")
	public void i_should_see_an_error_message_informing_the_User_about_invalid_credentials()  {
		
		Assert.assertTrue(Elements.VerifyTextEquals(LoginPage.mainWarning,"Warning: No match for E-Mail Address and/or Password."));
	    
	}
	
	@When("^I reset the forgotten password for \"([^\"]*)\"$")
	public void i_reset_the_forgotten_password_for(String email) {
	    
		Elements.click(LoginPage.forgottenPassword);
		Elements.TypeText(ForgotPasswordPage.emailField,email);
		Elements.click(ForgotPasswordPage.ContinueButton);
		
	}

	@Then("^I should see a message informing that the password reset details have been sent to the email address$")
	public void i_should_see_a_message_informing_that_the_password_reset_details_have_been_sent_to_the_email_address()  {
	    
		Assert.assertTrue(Elements.VerifyTextEquals(LoginPage.mainWarning,"An email with a confirmation link has been sent your email address."));
		
	}

}
