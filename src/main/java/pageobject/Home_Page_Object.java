package pageobject;


import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page_Object extends BaseClass {

    public WebElement getText() {
        return text;
    }

    @FindBy(xpath ="//span[contains(text(), 'Products')]")
    WebElement text;

    @FindBy(id ="add-to-cart-sauce-labs-backpack")
    WebElement add_cart_CTA;

    @FindBy(className ="shopping_cart_link")
    WebElement cart;

    public Home_Page_Object(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void addProduct(){
        fluentWait(getDriver(),add_cart_CTA,60);
        add_cart_CTA.click();
    }

public void clickCart(){
        fluentWait(getDriver(),cart,60);
        cart.click();
}


}
