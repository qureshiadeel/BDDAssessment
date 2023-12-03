package pageobject;


import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_Object extends BaseClass {

    @FindBy(id ="user-name")
    WebElement email;

    @FindBy(id ="password")
    WebElement password;

    @FindBy(id ="login-button")
    WebElement login_CTA;

    public WebElement getText() {
        return text;
    }

    @FindBy(xpath ="//h3[contains(text(),\"Epic sadface: Username and password do not match any user in this service\")]")
    WebElement text;


    public Login_Page_Object(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterEmail(String em){
    fluentWait(getDriver(),email,60);
    email.sendKeys(em);
    }
    public void enterPassword(String pwd){
        fluentWait(getDriver(),password,60);
        password.sendKeys(pwd);
    }
    public void clickCTA(){
        fluentWait(getDriver(),login_CTA,60);
        login_CTA.click();
    }



}
