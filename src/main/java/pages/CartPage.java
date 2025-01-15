package pages;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class CartPage {
    public final String CART_ICON = "//ul[@id='gh-eb']/li[@id='gh-minicart-hover']";

    @FindBy(xpath = CART_ICON)
    WebElement goToCartButton;

    public CartPage() {
        CommonUtils.waitForPresenceOfElement(CART_ICON);
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public int getCountOfItemInCart() {
        return Integer.parseInt(goToCartButton.getText());
    }
}
