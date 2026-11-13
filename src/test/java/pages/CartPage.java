package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By itemName = By.className("inventory_item_name");
    private By itemPrice = By.className("inventory_item_price");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItemNameInCart() {
        return getText(itemName);
    }

    public String getItemPriceInCart() {
        return getText(itemPrice);
    }

    public void clickCheckout() {
        click(checkoutButton);
    }
}
