package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends BasePage {

    private By cartIcon = By.className("shopping_cart_link");
    private By cartBadge = By.className("shopping_cart_badge");
    private By allItemNames = By.className("inventory_item_name");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getAllItemNames() {
        return driver.findElements(allItemNames)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    private By getAddToCartButton(String itemName) {
        String formattedName = itemName.toLowerCase().replace(" ", "-");
        return By.id("add-to-cart-" + formattedName);
    }

    public void addItemToCart(String itemName) {
        click(getAddToCartButton(itemName));
    }

    public String getItemPriceByName(String itemName) {
        By priceLocator = By.xpath(String.format(
                "//div[contains(@class, 'inventory_item')][.//div[text()='%s']]//div[@class='inventory_item_price']",
                itemName));
        return getText(priceLocator);
    }

    public void goToCart() {
        click(cartIcon);
    }
}
