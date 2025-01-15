package pages;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class HomePage {

    public final String MAIN_SEARCH_TEXT = "//input[@aria-label='Search for anything']";
    public final String SEARCHED_RESULTS_ROOT = "//ul[contains(@class,'srp-results')]";

    @FindBy(xpath = MAIN_SEARCH_TEXT)
    WebElement searchBox;

    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchButton;

    @FindBy(xpath = SEARCHED_RESULTS_ROOT + "/li[1]//div[contains(@class,'s-item__info')]/a")
    WebElement firstSearchedItem;

    public HomePage() {
        CommonUtils.waitForPresenceOfElement(MAIN_SEARCH_TEXT);
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public HomePage searchTextOnApp(String text) {
        searchBox.sendKeys(text);
        searchButton.click();
        CommonUtils.waitForPresenceOfElement(SEARCHED_RESULTS_ROOT);
        return this;
    }

    public void selectFirstSearchedItem() {
        firstSearchedItem.click();
    }
}
