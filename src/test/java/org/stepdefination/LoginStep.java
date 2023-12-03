package org.stepdefination;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.ITestResult;
import pageobject.Home_Page_Object;
import pageobject.Login_Page_Object;


public class LoginStep extends BaseClass {

    private Login_Page_Object loginPageObject;
    private Home_Page_Object homePageObject;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
      Setup();
    }

    @When("the user enters the email {string} and password {string}")
    public void theUserEntersCredentials(String email, String password) {
        loginPageObject = new Login_Page_Object(getDriver());
        loginPageObject.enterEmail(email);
        loginPageObject.enterPassword(password);

    }
    @When("clicks the login button")
    public void clicks_the_login_button() {
        loginPageObject.clickCTA();
    }

    @Then("the user should be on the home page with the title {string}")
    public void theUserIsOnHomePageWithTitle(String title) {
        homePageObject = new Home_Page_Object(getDriver());
        fluentWait_Text(getDriver(), homePageObject.getText(), "Products", 60);
        Assert.assertEquals(homePageObject.getText().getText(), "Products");
    }
    @Then("an error message should be displayed with the title {string}")
    public void anErrorMessageShouldBeDisplayed(String title) {
        fluentWait_Text(getDriver(), loginPageObject.getText(), "Epic sadface: Username and password do not match any user in this service", 60);
        Assert.assertEquals(loginPageObject.getText().getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @And("the user closes the app")
    public void theUserClosesTheApp() {
        Teardown();

    }

}
