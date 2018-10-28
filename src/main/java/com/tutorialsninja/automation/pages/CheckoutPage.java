package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

public class CheckoutPage {
	
	public CheckoutPage() {
		
		PageFactory.initElements(Base.driver,this);
		
	}
	
	@FindBy(id="button-payment-address")
	public static WebElement continueButtonInBillDetailsSection;
	
	@FindBy(id="button-shipping-address")
	public static WebElement continueButtonInDeliveryDetailsSection;
	
	@FindBy(id="button-shipping-method")
	public static WebElement continueButtionInDeliveryMethodSection;
	
	@FindBy(name="agree")
	public static WebElement termsAndConditions;
	
	@FindBy(id="button-payment-method")
	public static WebElement continueButtonInPaymentMethodSection;
	
	@FindBy(id="button-confirm")
	public static WebElement confirmOrderButton;
	
	public static void  placeOrder() {
		
		Elements.click(CheckoutPage.continueButtonInBillDetailsSection);
		Elements.click(CheckoutPage.continueButtonInDeliveryDetailsSection);
		Elements.click(CheckoutPage.continueButtionInDeliveryMethodSection);
		Elements.click(CheckoutPage.termsAndConditions);
		Elements.click(CheckoutPage.continueButtonInPaymentMethodSection);
		Elements.click(CheckoutPage.confirmOrderButton);
		
	}

}
