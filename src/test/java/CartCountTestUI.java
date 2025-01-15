
import base.BaseUITest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ItemDetailsPage;
import utils.CommonUtils;

public class CartCountTestUI extends BaseUITest {

    @Test
    public void cartCountTest() {
        new HomePage().searchTextOnApp("Book").selectFirstSearchedItem();
        CommonUtils.switchToNewlyOpenedWindow();
        new ItemDetailsPage().clickAddToCart();
        int itemsInCart = new CartPage().getCountOfItemInCart();
        Assert.assertEquals(itemsInCart, 1, "Numbers of items in cart is not correct");
    }
}
