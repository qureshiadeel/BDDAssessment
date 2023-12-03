package pageobject;


import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart_Page_Object extends BaseClass {


    @FindBy(id ="checkout")
    WebElement checkout_CTA;
    @FindBy(id ="first-name")
    WebElement first_name;
    @FindBy(id ="last-name")
    WebElement last_name;
    @FindBy(id ="postal-code")
    WebElement postal_code;
    @FindBy(id ="continue")
    WebElement continue_CTA;
    @FindBy(id ="finish")
    WebElement finish_CTA;

    public WebElement getText() {
        return text;
    }

    @FindBy(className ="complete-header")
    WebElement text;

    public Cart_Page_Object(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickCheckout(){
        fluentWait(getDriver(),checkout_CTA,60);
        checkout_CTA.click();
    }
public void enterDetailsAndClickContinue(String first, String last, String postal){
        fluentWait(getDriver(),first_name,60);
        first_name.sendKeys(first);
        fluentWait(getDriver(),last_name,60);
        last_name.sendKeys(last);
        fluentWait(getDriver(),postal_code,60);
        postal_code.sendKeys(postal);
        fluentWait(getDriver(),continue_CTA,60);
        continue_CTA.click();
}

public void clickFinish(){
        fluentWait(getDriver(),finish_CTA,60);
        finish_CTA.click();
}


}
