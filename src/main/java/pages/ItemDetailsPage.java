package pages;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class ItemDetailsPage {

    public final String ADD_TO_CART = "//ul[@data-testid='x-buybox-cta']//a[@id='atcBtn_btn_1']";

    @FindBy(xpath = ADD_TO_CART)
    WebElement addToCartButton;

    public ItemDetailsPage() {
        CommonUtils.waitForPresenceOfElement(ADD_TO_CART);
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }
}