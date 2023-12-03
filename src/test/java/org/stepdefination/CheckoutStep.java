package org.stepdefination;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.Cart_Page_Object;
import pageobject.Home_Page_Object;
import pageobject.Login_Page_Object;


public class CheckoutStep extends BaseClass {

    private Login_Page_Object loginPageObject;
    private Home_Page_Object homePageObject;

    private Cart_Page_Object cartPageObject;


    @Given("the application is open")
    public void givenApplicationIsOpen() {
        Setup();
    }

    @Given("the user is logged in")
    public void givenUserIsLoggedIn() {
        loginPageObject = new Login_Page_Object(getDriver());
        loginPageObject.enterEmail("standard_user");
        loginPageObject.enterPassword("secret_sauce");
        loginPageObject.clickCTA();
    }

    @Given("a product is added to the shopping cart")
    public void givenProductIsAddedToCart() {
      homePageObject=new Home_Page_Object(getDriver());
      homePageObject.addProduct();
    }

    @When("the user navigates to the shopping cart")
    public void whenUserNavigatesToCart() {
        homePageObject=new Home_Page_Object(getDriver());
        homePageObject.clickCart();
    }

    @When("initiates the checkout process")
    public void whenUserInitiatesCheckout() {
        cartPageObject=new Cart_Page_Object(getDriver());
        cartPageObject.clickCheckout();

    }

//    @When("enters first name {string} and last name {string} and postal {string} and proceeds by clicking the 'Continue' button")
//    public void whenUserEntersValidDetails(String first,String last, String postal) {
//        cartPageObject=new Cart_Page_Object(getDriver());
//        cartPageObject.enterDetailsAndClickContinue(first,last,postal);
//    }

    @When("enters first name {string} and last name {string} and postal {string} and proceeds by clicking the Continue button")
    public void enters_first_name_and_last_name_and_postal_and_proceeds_by_clicking_the_continue_button(String string, String string2, String string3) {
                cartPageObject=new Cart_Page_Object(getDriver());
        cartPageObject.enterDetailsAndClickContinue(string,string2,string3);
    }


    @When("finalizes the purchase by clicking on the 'Finish' button")
    public void whenUserFinalizesPurchase() {
        cartPageObject=new Cart_Page_Object(getDriver());
        cartPageObject.clickFinish();
    }

    @Then("the user should validate the displayed confirmation text")
    public void thenValidateConfirmationText() {
        cartPageObject=new Cart_Page_Object(getDriver());
        fluentWait_Text(getDriver(), cartPageObject.getText(),"Thank you for your order!",60);
        Assert.assertEquals(cartPageObject.getText().getText().toString(),"Thank you for your order!");
    }

    @And("the user closes the application")
    public void theUserClosesTheApplcation() {
        Teardown();

    }

}
